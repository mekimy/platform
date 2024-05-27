package com.syskimy.scatalog.daos.services;

import com.syskimy.scatalog.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface CategoryDaoService {
    CategoryEntity save(CategoryEntity category);
    Page<CategoryEntity> findPaginated(Specification<CategoryEntity> specification, Pageable pageable);
    boolean existsBy(Specification<CategoryEntity> specification);
    CategoryEntity findOne(Specification<CategoryEntity> specification);
}
