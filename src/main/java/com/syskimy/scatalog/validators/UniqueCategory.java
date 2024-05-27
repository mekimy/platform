package com.syskimy.scatalog.validators;

import com.syskimy.scatalog.validators.impl.UniqueCategoryValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Constraint(validatedBy = UniqueCategoryValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueCategory {
    String message() default "{unique category}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
