package com.syskimy.scatalog.daos.services;

import com.syskimy.scatalog.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface ProductDaoService {
    ProductEntity save(ProductEntity entity);
    Page<ProductEntity> findPaginated(Specification<ProductEntity> specification, Pageable pageable);
    boolean existsBy(Specification<ProductEntity> specification);
    ProductEntity findOne(Specification<ProductEntity> specification);
}
