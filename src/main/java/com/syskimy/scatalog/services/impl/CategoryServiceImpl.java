package com.syskimy.scatalog.services.impl;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.syskimy.scatalog.daos.services.CategoryDaoService;
import com.syskimy.scatalog.daos.specifications.CategorySpecification;
import com.syskimy.scatalog.entities.CategoryEntity;
import com.syskimy.scatalog.exceptions.InternalServerErrorException;
import com.syskimy.scatalog.exceptions.enums.InternalServerErrorExceptionTitleEnum;
import com.syskimy.scatalog.mappers.CategoryMapper;
import com.syskimy.scatalog.resources.category.CategoryGetResource;
import com.syskimy.scatalog.resources.category.CategoryPostResource;
import com.syskimy.scatalog.resources.csv.CsvCategoryResource;
import com.syskimy.scatalog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.input.BOMInputStream;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDaoService categoryDaoService;
    private final CategoryMapper categoryMapper;

    @Override
    public ResponseEntity<CategoryGetResource> create(CategoryPostResource categoryPostResource) {
        CategoryEntity categoryEntity = categoryMapper.postResourceToEntity(categoryPostResource);

        categoryEntity = categoryDaoService.save(categoryEntity);

        CategoryGetResource categoryGetResource = categoryMapper.entityToGetResource(categoryEntity);

        return ResponseEntity.ok(categoryGetResource);
    }

    @Override
    public ResponseEntity<Page<CategoryGetResource>> findPaginated(Pageable pageable) {
        Page<CategoryEntity> categoryEntities = categoryDaoService.findPaginated(null, pageable);

       Page<CategoryGetResource> categoryGetResourcePage = categoryEntities.map(categoryMapper::entityToGetResource);

       return ResponseEntity.ok(categoryGetResourcePage);
    }

    @Override
    @Transactional
    public ResponseEntity<Void> importCategories(MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(new BOMInputStream(file.getInputStream())))) {
            CsvToBean<CsvCategoryResource> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CsvCategoryResource.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<CsvCategoryResource> list = csvToBean.parse();

            for (CsvCategoryResource row: list) {
                CategoryPostResource resource = new CategoryPostResource();
                resource.setName(row.getName());
                this.create(resource);
            }

        } catch (Exception ex) {
            log.info(ex.getMessage());
            throw new InternalServerErrorException(InternalServerErrorExceptionTitleEnum.CSV_IMPORT, "error occurred while importing this shit");
        }

        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<CategoryGetResource> findById(Long categoryId) {
        log.debug("Will retrieve a category with id {} from the database...", categoryId);
        CategoryEntity category = categoryDaoService.findOne(
                CategorySpecification.withId(categoryId)
        );
        log.info("Retrieved a category with data {}", category);

        log.debug("Will map the category entity to get resources...");
        CategoryGetResource resource = categoryMapper.entityToGetResource(category);
        log.info("Category mapped successfully {}", resource);

        return ResponseEntity.ok(resource);
    }
}
