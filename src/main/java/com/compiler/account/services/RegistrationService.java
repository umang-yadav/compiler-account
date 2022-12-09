package com.compiler.account.services;

import com.compiler.account.constants.Constants;
import com.compiler.account.dto.request.RegistrationRequestDTO;
import com.compiler.account.enums.UserRole;
import com.compiler.account.helper.UserHelper;
import com.compiler.account.models.UserModel;
import com.compiler.account.utils.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class RegistrationService {

    @Autowired
    private EmailValidator emailValidator;

    @Autowired
    private UserHelper userHelper;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private EmailService emailService;

    public String register(RegistrationRequestDTO registrationRequestDTO) throws MessagingException {
        boolean isValidEmail = emailValidator.test(registrationRequestDTO.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException(Constants.INVALID_EMAIL);
        }

        String token = userHelper.signUpUser(
                new UserModel(
                        registrationRequestDTO.getFirstName(),
                        registrationRequestDTO.getLastName(),
                        registrationRequestDTO.getEmail(),
                        registrationRequestDTO.getPassword(),
                        UserRole.USER
                )
        );

        String link = Constants.CONFIRM_TOKEN_ENDPOINT + token;
        emailService.sendEmail(registrationRequestDTO.getEmail(), link);
        return token;
    }

}
