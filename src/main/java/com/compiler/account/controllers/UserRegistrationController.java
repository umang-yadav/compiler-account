package com.compiler.account.controllers;

import com.compiler.account.constants.Constants;
import com.compiler.account.dto.request.RegistrationRequestDTO;
import com.compiler.account.dto.response.BaseResponse;
import com.compiler.account.services.EmailService;
import com.compiler.account.services.RegistrationService;
import com.compiler.account.services.TokenService;
import com.compiler.account.utils.SuccessMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/account/v1")
public class UserRegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/register")
    public ResponseEntity<BaseResponse> registerUser(@RequestBody RegistrationRequestDTO registrationRequestDTO) throws MessagingException {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(registrationService.register(registrationRequestDTO));
        baseResponse.setMeta(SuccessMeta.createSuccessMetaData());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/confirm")
    public ResponseEntity<BaseResponse> confirmToken(@RequestParam(Constants.TOKEN) String token){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(tokenService.confirm(token));
        baseResponse.setMeta(SuccessMeta.createSuccessMetaData());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
