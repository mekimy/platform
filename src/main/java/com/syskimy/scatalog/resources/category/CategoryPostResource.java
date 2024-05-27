package com.syskimy.scatalog.resources.category;

import com.syskimy.scatalog.validators.UniqueCategory;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryPostResource {
    @NotBlank
    @UniqueCategory
    private String name;
}
