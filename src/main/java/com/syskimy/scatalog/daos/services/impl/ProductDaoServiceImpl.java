package com.syskimy.scatalog.daos.services.impl;

import com.syskimy.scatalog.daos.repositories.ProductRepository;
import com.syskimy.scatalog.daos.services.ProductDaoService;
import com.syskimy.scatalog.entities.ProductEntity;
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
public class ProductDaoServiceImpl implements ProductDaoService {
    private final ProductRepository productRepository;

    @Override
    public ProductEntity save(ProductEntity entity) {
        return productRepository.save(entity);
    }

    @Override
    public Page<ProductEntity> findPaginated(Specification<ProductEntity> specification, Pageable pageable) {
        return productRepository.findAll(specification, pageable);
    }

    @Override
    public boolean existsBy(Specification<ProductEntity> specification) {
        return productRepository.exists(specification);
    }

    @Override
    public ProductEntity findOne(Specification<ProductEntity> specification) {
        return productRepository.findOne(specification)
                .orElseThrow(() -> {
                   log.warn("the product not found given the specific criteria");
                   throw new ResourceNotFoundException(
                           ResourceNotFoundTitleEnum.PRODUCT_NOT_FOUND,
                           "the product not found given the specific criteria"
                   );
                });
    }
}
