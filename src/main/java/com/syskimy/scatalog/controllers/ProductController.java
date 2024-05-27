package com.syskimy.scatalog.controllers;

import com.syskimy.scatalog.resources.product.ProductGetResource;
import com.syskimy.scatalog.resources.product.ProductPostResource;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/catalogMgtApi/products")
public interface ProductController {
    @PostMapping
    ResponseEntity<ProductGetResource> create(@Valid @RequestBody ProductPostResource resource);

    @GetMapping
    ResponseEntity<Page<ProductGetResource>> findPaginated(@RequestParam(name = "search", required = false) String search, Pageable pageable);
}
