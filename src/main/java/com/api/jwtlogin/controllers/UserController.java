package com.api.jwtlogin.controllers;

import com.api.jwtlogin.dtos.UserPostRequestDTO;
import com.api.jwtlogin.dtos.UserPutRequestDTO;
import com.api.jwtlogin.dtos.UserResponseDTO;
import com.api.jwtlogin.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PutMapping
    ResponseEntity<Void> updateUser(@RequestBody @Valid UserPutRequestDTO userPutRequestDTO) {
        userService.updateUser(userPutRequestDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
