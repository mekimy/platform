package com.syskimy.scatalog.services;

import com.syskimy.scatalog.resources.category.CategoryGetResource;
import com.syskimy.scatalog.resources.category.CategoryPostResource;
import com.syskimy.scatalog.resources.product.ProductGetResource;
import com.syskimy.scatalog.resources.product.ProductPostResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    ResponseEntity<ProductGetResource> create(ProductPostResource productPostResource);
    ResponseEntity<Page<ProductGetResource>> findPaginated(String name,
                                                           Pageable pageable);
//    ResponseEntity<Void> importCategories(MultipartFile file);
    ResponseEntity<ProductGetResource> findById(Long productId);
}
