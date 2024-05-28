package com.syskimy.scatalog.exceptions.enums;

public enum InternalServerErrorExceptionTitleEnum implements BaseExceptionEnum {
    CSV_IMPORT("INT_SET_ERR_1"),
    FILE_COPY("INT_SET_ERR_2"),
    FILE_LOAD("INT_SET_ERR_3");

    private String code;

    InternalServerErrorExceptionTitleEnum(String code) { this.code = code; }


    @Override
    public String getCode() {
        return code;
    }
}
