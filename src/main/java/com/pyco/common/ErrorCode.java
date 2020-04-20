package com.pyco.common;

public enum ErrorCode {
    SUCCESS(200),
    EXISTING_DATA(204),             //bad get method
    NOT_FOUND_DATA(404),
    CREATED(201),
    ACCEPTED(202);

    private final int code;


    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
