package com.syskimy.scatalog.services.impl;

import com.syskimy.scatalog.daos.services.ProductDaoService;
import com.syskimy.scatalog.daos.specifications.ProductSpecification;
import com.syskimy.scatalog.entities.ProductEntity;
import com.syskimy.scatalog.mappers.ProductMapper;
import com.syskimy.scatalog.resources.category.CategoryGetResource;
import com.syskimy.scatalog.resources.product.ProductGetResource;
import com.syskimy.scatalog.resources.product.ProductPostResource;
import com.syskimy.scatalog.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductDaoService productDaoService;

    @Override
    public ResponseEntity<ProductGetResource> create(ProductPostResource productPostResource) {
        ProductEntity productEntity = productMapper.postResourceToEntity(productPostResource);

        productEntity = productDaoService.save(productEntity);

        ProductGetResource resource = productMapper.entityToGetResource(productEntity);

        return ResponseEntity.ok(resource);
    }

    @Override
    public ResponseEntity<Page<ProductGetResource>> findPaginated(String search,
                                                                  Pageable pageable) {

        Specification<ProductEntity> specification = null;

        if (!ObjectUtils.isEmpty(search)) {
            log.debug("will add the specification withSearch {}...", search);
            specification = ProductSpecification.withSearch(search);
        }

        Page<ProductEntity> productEntityPage = productDaoService.findPaginated(specification, pageable);

        Page<ProductGetResource> productGetResourcePage = productEntityPage.map(productMapper::entityToGetResource);

        return ResponseEntity.ok(productGetResourcePage);
    }

    @Override
    public ResponseEntity<ProductGetResource> findById(Long productId) {
        ProductEntity productEntity = productDaoService.findOne(ProductSpecification.withId(productId));

        ProductGetResource productGetResource = productMapper.entityToGetResource(productEntity);

        return ResponseEntity.ok(productGetResource);
    }
}
