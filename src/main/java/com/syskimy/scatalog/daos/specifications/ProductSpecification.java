package com.syskimy.scatalog.daos.specifications;

import com.syskimy.scatalog.entities.ProductEntity;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {
    public static Specification<ProductEntity> withId(Long id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public static Specification<ProductEntity> withSearch(String search) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get("name")),
                search.toLowerCase() + "%"
        );
    }
}
