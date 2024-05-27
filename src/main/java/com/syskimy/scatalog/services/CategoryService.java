package com.syskimy.scatalog.services;

import com.syskimy.scatalog.resources.category.CategoryGetResource;
import com.syskimy.scatalog.resources.category.CategoryPostResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface CategoryService {
    ResponseEntity<CategoryGetResource> create(CategoryPostResource categoryPostResource);
    ResponseEntity<Page<CategoryGetResource>> findPaginated(Pageable pageable);
    ResponseEntity<Void> importCategories(MultipartFile file);
    ResponseEntity<CategoryGetResource> findById(Long categoryId);
}
