package com.syskimy.scatalog.resources.category;

import com.syskimy.scatalog.validators.UniqueCategory;
import lombok.Data;

@Data
public class CategoryPatchResource {
    @UniqueCategory
    private String name;
}
