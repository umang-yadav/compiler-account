package com.compiler.account.enums;

import lombok.ToString;
import org.springframework.http.HttpStatus;

@ToString
public enum SuccessCode {

    SUCCESS_CODE("COM_ACC_200002", "Success", HttpStatus.OK);

    private final String code;
    private final String message;
    private final HttpStatus httpStatusCode;

    private SuccessCode(String code, String message, HttpStatus httpStatusCode) {
        this.code = code;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

    public HttpStatus getHttpStatusCode() {
        return httpStatusCode;
    }
}
