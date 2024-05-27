package com.syskimy.scatalog.resources.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPatchResource {
    private String name;
    private Double price;
}
