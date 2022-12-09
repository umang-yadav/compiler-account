package com.compiler.account.utils;

import java.util.UUID;

public class TokenGenerator {
    public static String generateToken(){

        String token = UUID.randomUUID().toString();
        return token;
    }
}
