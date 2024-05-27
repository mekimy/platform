package com.syskimy.scatalog.resources.errors;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ErrorDetailResource {
    private String title;
    private int status;
    private String detail;
    private long timestamp;
    private String developerMessage;
    private String code;
    private Map<String, List<ValidationErrorResource>> errors = new HashMap<>();
}
