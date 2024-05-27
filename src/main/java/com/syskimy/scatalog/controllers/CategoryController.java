package com.syskimy.scatalog.controllers;

import com.syskimy.scatalog.resources.category.CategoryGetResource;
import com.syskimy.scatalog.resources.category.CategoryPatchResource;
import com.syskimy.scatalog.resources.category.CategoryPostResource;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/catalogMgtApi/categories")
public interface CategoryController {
    @PostMapping
    ResponseEntity<CategoryGetResource> create(@Valid @RequestBody CategoryPostResource resource);

    @GetMapping
    ResponseEntity<Page<CategoryGetResource>> findPaginated(Pageable pageable);

    @PostMapping("/import")
    ResponseEntity<Void> importCategories(@RequestParam("file") MultipartFile file);

    @GetMapping("/{id}")
    ResponseEntity<CategoryGetResource> findById(@PathVariable Long id);

    @PatchMapping("/{id}")
    ResponseEntity<CategoryGetResource> patchById(@PathVariable Long id,
                                                  @Valid @RequestBody CategoryPatchResource resource);
}
