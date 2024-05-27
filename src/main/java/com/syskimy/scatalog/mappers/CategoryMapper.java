package com.syskimy.scatalog.mappers;

import com.syskimy.scatalog.entities.CategoryEntity;
import com.syskimy.scatalog.resources.category.CategoryGetResource;
import com.syskimy.scatalog.resources.category.CategoryPostResource;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(
        componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public abstract class CategoryMapper {
    public abstract CategoryEntity postResourceToEntity(CategoryPostResource resource);
    public abstract CategoryGetResource entityToGetResource(CategoryEntity entity);
}
