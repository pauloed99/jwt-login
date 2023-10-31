package com.api.jwtlogin.services;

import com.api.jwtlogin.dtos.AuthenticationRequestDTO;
import com.api.jwtlogin.dtos.AuthenticationResponseDTO;
import com.api.jwtlogin.dtos.UserPostRequestDTO;
import com.api.jwtlogin.dtos.UserResponseDTO;
import com.api.jwtlogin.enums.UsersEnum;
import com.api.jwtlogin.exceptions.BadRequestException;
import com.api.jwtlogin.models.User;
import com.api.jwtlogin.repositories.UserRepository;
import com.api.jwtlogin.security.TokenService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private TokenService tokenService;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;

    public AuthenticationResponseDTO login(AuthenticationRequestDTO authenticationRequestDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationRequestDTO.getEmail()
                , authenticationRequestDTO.getPassword());
        var auth = authenticationManager.authenticate(usernamePassword);

        return new AuthenticationResponseDTO(tokenService.generateToken((User) auth.getPrincipal()));
    }

    public UserResponseDTO register(UserPostRequestDTO userPostRequestDTO) {
        if (userRepository.findByEmail(userPostRequestDTO.getEmail()) != null) {
            throw new BadRequestException(UsersEnum.USER_EMAIL_ALREADY_USED_EXCEPTION.getMessage());
        }

        String encryptedPassword = passwordEncoder.encode(userPostRequestDTO.getPassword());
        userPostRequestDTO.setPassword(encryptedPassword);
        User userToBeSaved = modelMapper.map(userPostRequestDTO, User.class);

        return modelMapper.map(userRepository.save(userToBeSaved), UserResponseDTO.class);
    }
}
