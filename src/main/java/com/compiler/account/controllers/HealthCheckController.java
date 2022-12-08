package com.compiler.account.controllers;

import com.compiler.account.dto.response.BaseResponse;
import com.compiler.account.utils.SuccessMeta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/v1")
public class HealthCheckController {

    /**
     * Health Check for Application
     * @return
     */
    @GetMapping("/health")
    public BaseResponse healthCheck() {
        BaseResponse baseResponse = new BaseResponse<>();
        baseResponse.setData("OK");
        baseResponse.setMeta(SuccessMeta.createSuccessMetaData());
        return baseResponse;
    }
}
