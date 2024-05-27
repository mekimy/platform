package com.syskimy.scatalog.resources.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ValidationErrorResource {
    private String code;
    private String message;
}
