package com.syskimy.scatalog.controllers.impl;

import com.syskimy.scatalog.controllers.CategoryController;
import com.syskimy.scatalog.resources.category.CategoryGetResource;
import com.syskimy.scatalog.resources.category.CategoryPostResource;
import com.syskimy.scatalog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class CategoryControllerImpl implements CategoryController {
    private final CategoryService categoryService;

    @Override
    public ResponseEntity<CategoryGetResource> create(CategoryPostResource resource) {
        return categoryService.create(resource);
    }

    @Override
    public ResponseEntity<Page<CategoryGetResource>> findPaginated(Pageable pageable) {
        return categoryService.findPaginated(pageable);
    }

    @Override
    public ResponseEntity<Void> importCategories(MultipartFile file) {
        return categoryService.importCategories(file);
    }
}
