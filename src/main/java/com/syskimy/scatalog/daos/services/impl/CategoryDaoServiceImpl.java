package com.syskimy.scatalog.daos.services.impl;

import com.syskimy.scatalog.daos.repositories.CategoryRepository;
import com.syskimy.scatalog.daos.services.CategoryDaoService;
import com.syskimy.scatalog.entities.CategoryEntity;
import com.syskimy.scatalog.exceptions.ResourceNotFoundException;
import com.syskimy.scatalog.exceptions.enums.ResourceNotFoundTitleEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryDaoServiceImpl implements CategoryDaoService {
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryEntity save(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    @Override
    public Page<CategoryEntity> findPaginated(Specification<CategoryEntity> specification, Pageable pageable) {
        return categoryRepository.findAll(specification, pageable);
    }

    @Override
    public boolean existsBy(Specification<CategoryEntity> specification) {
        return categoryRepository.exists(specification);
    }

    @Override
    public CategoryEntity findOne(Specification<CategoryEntity> specification) {
        return categoryRepository.findOne(specification)
                .orElseThrow(() -> {
                    log.warn("category not found with the given specifications");
                    return new ResourceNotFoundException(
                            ResourceNotFoundTitleEnum.CATEGORY_NOT_FOUND,
                            "category not found with the given specifications"
                    );
                });
    }
}
