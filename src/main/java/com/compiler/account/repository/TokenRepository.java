package com.compiler.account.repository;

import com.compiler.account.models.TokenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<TokenModel, Integer> {

    Optional<TokenModel> findByToken(String token);

}
