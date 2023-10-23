package com.api.jwtlogin.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserPostRequestDTO {
    @NotBlank(message = "The email is required!")
    private String email;
    @NotBlank(message = "The name is required!")
    private String name;
    @NotBlank(message = "The password is required!")
    private String password;
    @NotNull(message = "The birthDate is required!")
    private LocalDate birthDate;
    @Valid
    @NotNull(message = "The address is required!")
    private AddressDTO address;
}