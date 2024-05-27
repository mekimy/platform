package com.syskimy.scatalog.mappers;

import com.syskimy.scatalog.daos.services.CategoryDaoService;
import com.syskimy.scatalog.daos.specifications.CategorySpecification;
import com.syskimy.scatalog.entities.CategoryEntity;
import com.syskimy.scatalog.entities.ProductEntity;
import com.syskimy.scatalog.resources.product.ProductGetResource;
import com.syskimy.scatalog.resources.product.ProductPostResource;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Mapper(
        componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public abstract class ProductMapper {
    private CategoryDaoService categoryDaoService;
    private CategoryMapper categoryMapper;

    @Autowired
    void setDependencies(CategoryDaoService categoryDaoService,
                         CategoryMapper categoryMapper) {
        this.categoryDaoService = categoryDaoService;
        this.categoryMapper = categoryMapper;
    }

    public abstract ProductEntity postResourceToEntity(ProductPostResource resource);
    public abstract ProductGetResource entityToGetResource(ProductEntity entity);

    @AfterMapping
    void afterEntityToGetResource(ProductEntity entity, @MappingTarget ProductGetResource resource) {
        resource.setCategory(categoryMapper.entityToGetResource(entity.getCategory()));
    }
    @BeforeMapping
    void beforePostResourceToEntity(ProductPostResource resource,
                                    @MappingTarget ProductEntity productEntity) {
        CategoryEntity categoryEntity = this.categoryDaoService.findOne(CategorySpecification.withId(resource.getCategoryId()));
        productEntity.setCategory(categoryEntity);
    }
}
