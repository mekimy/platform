package com.syskimy.scatalog.controllers.impl;

import com.syskimy.scatalog.controllers.ProductController;
import com.syskimy.scatalog.resources.product.ProductGetResource;
import com.syskimy.scatalog.resources.product.ProductPostResource;
import com.syskimy.scatalog.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
    private final ProductService productService;

    @Override
    public ResponseEntity<ProductGetResource> create(ProductPostResource resource) {
        return productService.create(resource);
    }

    @Override
    public ResponseEntity<Page<ProductGetResource>> findPaginated(String search, Pageable pageable) {
        return productService.findPaginated(search, pageable);
    }
}
