package com.syskimy.scatalog.daos.specifications;

import com.syskimy.scatalog.entities.CategoryEntity;
import org.springframework.data.jpa.domain.Specification;

public class CategorySpecification {
    public static Specification<CategoryEntity> withName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
    }
}
