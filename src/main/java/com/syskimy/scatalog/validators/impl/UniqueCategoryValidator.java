package com.syskimy.scatalog.validators.impl;

import com.syskimy.scatalog.daos.services.CategoryDaoService;
import com.syskimy.scatalog.daos.specifications.CategorySpecification;
import com.syskimy.scatalog.validators.UniqueCategory;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.util.ObjectUtils;

@RequiredArgsConstructor
public class UniqueCategoryValidator implements ConstraintValidator<UniqueCategory, String> {
    private final CategoryDaoService categoryDaoService;

    @Override
    public void initialize(UniqueCategory constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return ObjectUtils.isEmpty(s) || !categoryDaoService.existsBy(CategorySpecification.withName(s));
    }
}
