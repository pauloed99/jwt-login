package com.api.jwtlogin.controllers;

import com.api.jwtlogin.dtos.UserPostRequestDTO;
import com.api.jwtlogin.dtos.UserPutRequestDTO;
import com.api.jwtlogin.dtos.UserResponseDTO;
import com.api.jwtlogin.models.User;
import com.api.jwtlogin.security.TokenService;
import com.api.jwtlogin.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private TokenService tokenService;


    @GetMapping
    public ResponseEntity<UserResponseDTO> getUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        return ResponseEntity.ok(userService.getUser(token));
    }

    @PutMapping
    ResponseEntity<Void> updateUser(@RequestBody @Valid UserPutRequestDTO userPutRequestDTO, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        userService.updateUser(userPutRequestDTO, token);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    ResponseEntity<Void> deleteUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        userService.deleteUser(token);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
