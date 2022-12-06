package com.compiler.account.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Meta implements Serializable {
    private String code;
    private String message;
    private String responseId;
    private String requestId;

    public Meta(String code, String message, String responseId, String requestId) {
        this.code = code;
        this.message = message;
        this.responseId = responseId;
        this.requestId = requestId;
    }
}
