package com.syskimy.scatalog.resources.product;

import com.syskimy.scatalog.resources.category.CategoryGetResource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductGetResource {
    private Long id;
    private String name;
    private Double price;
    private CategoryGetResource category;
}
