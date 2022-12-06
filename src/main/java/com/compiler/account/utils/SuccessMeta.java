package com.compiler.account.utils;

import com.compiler.account.dto.response.Meta;
import com.compiler.account.enums.SuccessCode;

public class SuccessMeta {
    public static Meta createSuccessMetaData() {
        return new Meta(SuccessCode.SUCCESS_CODE.getCode(), SuccessCode.SUCCESS_CODE.getMessage(), "responseId", "requestId");
    }
}
