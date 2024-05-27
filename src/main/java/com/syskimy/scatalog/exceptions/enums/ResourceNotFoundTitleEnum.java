package com.syskimy.scatalog.exceptions.enums;

public enum ResourceNotFoundTitleEnum implements BaseExceptionEnum {
    RESOURCE_NOT_FOUND("RESOURCE_NOT_FOUND"),
    CATEGORY_NOT_FOUND("CATEGORY_NOT_FOUND"),
    PRODUCT_NOT_FOUND("PRODUCT_NOT_FOUND");

    private String code;

    ResourceNotFoundTitleEnum(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
