package com.api.jwtlogin.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddressDTO {
    private Long id;
    @NotBlank(message = "The cep is required!")
    private String cep;
    @NotBlank(message = "The street is required!")
    private String street;
    @NotBlank(message = "The neighbourhood is required!")
    private String neighbourhood;
    @NotBlank(message = "The city is required!")
    private String city;
    @NotBlank(message = "The uf is required!")
    @Size(min = 2, max = 2, message = "The uf must be only two characters!")
    private String uf;
}
