package com.api.jwtlogin.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
@Data
public class UserResponseDTO {
    private Long id;
    private String email;
    private String name;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate BirthDate;
    private AddressDTO address;
}
