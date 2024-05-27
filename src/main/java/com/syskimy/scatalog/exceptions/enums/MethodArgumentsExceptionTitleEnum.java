package com.syskimy.scatalog.exceptions.enums;

public enum MethodArgumentsExceptionTitleEnum implements BaseExceptionEnum {
    METHOD_ARGUMENT_NOT_VALID("C_BAD_REQ_ERR");

    private final String code;

    MethodArgumentsExceptionTitleEnum(String code) { this.code = code; }

    @Override
    public String getCode() {
        return this.code;
    }
}
