package com.compiler.account.constants;

public final class Constants {

    private Constants() {
    }

    public static final String USER_NOT_FOUND = "User with email %s not found";
    public static final String OK = "OK";
    public static final String TOKEN = "token";
    public static final String EMAIL_ALREADY_TAKEN = "email already taken";
    public static final String INVALID_EMAIL = "email not valid";
    public static final String CONFIRM_TOKEN_ENDPOINT = "http://localhost:8080/account/v1/confirm?token=";

}
