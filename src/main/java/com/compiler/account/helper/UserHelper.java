package com.compiler.account.helper;

import com.compiler.account.constants.Constants;
import com.compiler.account.models.TokenModel;
import com.compiler.account.models.UserModel;
import com.compiler.account.repository.UserRepository;
import com.compiler.account.services.TokenService;
import com.compiler.account.utils.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserHelper implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format(Constants.USER_NOT_FOUND, email)));
    }

    public String signUpUser(UserModel userModel) {
        boolean userExists = userRepository.findByEmail(userModel.getEmail()).isPresent();

        if (userExists) {
            throw new IllegalStateException(Constants.EMAIL_ALREADY_TAKEN);
        }

        String encodedPassword = bCryptPasswordEncoder.encode(userModel.getPassword());
        userModel.setPassword(encodedPassword);
        userRepository.save(userModel);

        String generatedToken = TokenGenerator.generateToken();
        TokenModel token = new TokenModel(generatedToken, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), userModel);

        tokenService.saveToken(token);

        return generatedToken;
    }
}
