package com.syskimy.scatalog.daos.services.impl;

import com.syskimy.scatalog.daos.repositories.CategoryRepository;
import com.syskimy.scatalog.daos.services.CategoryDaoService;
import com.syskimy.scatalog.entities.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryDaoServiceImpl implements CategoryDaoService {
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryEntity save(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    @Override
    public Page<CategoryEntity> findPaginated(Specification<CategoryEntity> specification, Pageable pageable) {
        return categoryRepository.findAll(specification, pageable);
    }

    @Override
    public boolean existsBy(Specification<CategoryEntity> specification) {
        return categoryRepository.exists(specification);
    }
}
