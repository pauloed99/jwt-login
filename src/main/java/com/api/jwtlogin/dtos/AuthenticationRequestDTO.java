package com.api.jwtlogin.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthenticationRequestDTO {
    @NotBlank(message = "The email is required!")
    private String email;
    @NotBlank(message = "The password is required!")
    private String password;
}
