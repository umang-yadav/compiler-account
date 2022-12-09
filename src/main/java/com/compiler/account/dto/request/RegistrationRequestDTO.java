package com.compiler.account.dto.request;
import lombok.Data;
import java.io.Serializable;

@Data
public class RegistrationRequestDTO implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
