package com.api.jwtlogin.controllers;

import com.api.jwtlogin.dtos.AuthenticationRequestDTO;
import com.api.jwtlogin.dtos.AuthenticationResponseDTO;
import com.api.jwtlogin.dtos.UserPostRequestDTO;
import com.api.jwtlogin.dtos.UserResponseDTO;
import com.api.jwtlogin.models.User;
import com.api.jwtlogin.repositories.UserRepository;
import com.api.jwtlogin.security.TokenService;
import com.api.jwtlogin.services.AuthenticationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("auth")
public class AuthenticationController {
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDTO> login(@RequestBody @Valid AuthenticationRequestDTO authenticationRequestDTO) {
        return ResponseEntity.ok(authenticationService.login(authenticationRequestDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody @Valid UserPostRequestDTO userPostRequestDTO) {
        System.out.println(4);
        return new ResponseEntity<>(authenticationService.register(userPostRequestDTO), HttpStatus.CREATED);
    }
}