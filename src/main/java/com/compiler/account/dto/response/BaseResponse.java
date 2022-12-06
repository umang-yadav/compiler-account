package com.compiler.account.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse<T extends Serializable> implements Serializable {
    private T data;

    private Meta meta;
}
