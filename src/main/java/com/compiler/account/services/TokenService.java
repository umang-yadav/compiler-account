package com.compiler.account.services;

import com.compiler.account.models.TokenModel;
import com.compiler.account.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    public void saveToken(TokenModel token) {
        tokenRepository.save(token);
    }

    public String confirm(String token) {

        return null;
    }
}
