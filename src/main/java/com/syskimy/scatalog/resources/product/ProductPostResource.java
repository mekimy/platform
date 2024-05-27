package com.syskimy.scatalog.resources.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPostResource {
    @NotBlank
    private String name;
    @NotNull
    private Double price;
    @NotNull
    private Long categoryId;
}
