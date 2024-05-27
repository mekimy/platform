package com.syskimy.scatalog.exceptions.enums;

public enum InternalServerErrorExceptionTitleEnum implements BaseExceptionEnum {
    CSV_IMPORT("INT_SET_ERR_1");

    private String code;

    InternalServerErrorExceptionTitleEnum(String code) { this.code = code; }


    @Override
    public String getCode() {
        return code;
    }
}
