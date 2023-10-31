package com.api.jwtlogin.services;

import com.api.jwtlogin.dtos.UserPostRequestDTO;
import com.api.jwtlogin.dtos.UserPutRequestDTO;
import com.api.jwtlogin.dtos.UserResponseDTO;
import com.api.jwtlogin.enums.UsersEnum;
import com.api.jwtlogin.exceptions.BadRequestException;
import com.api.jwtlogin.exceptions.RecordNotFoundException;
import com.api.jwtlogin.models.User;
import com.api.jwtlogin.repositories.UserRepository;
import com.api.jwtlogin.security.TokenService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private TokenService tokenService;
    private PasswordEncoder passwordEncoder;

    public UserResponseDTO getUser(String token) {
        token = token.replace("Bearer ", "");
        String tokenEmail = tokenService.validateToken(token);
        User user = userRepository.findUserByEmail(tokenEmail).orElseThrow(
                () -> new RecordNotFoundException(UsersEnum.USER_NOT_FOUND_EXCEPTION.getMessage())
        );
        return modelMapper.map(user, UserResponseDTO.class);
    }

    public void updateUser(UserPutRequestDTO userPutRequestDTO, String token) {
        token = token.replace("Bearer ", "");
        String tokenEmail = tokenService.validateToken(token);
        User user = userRepository.findUserByEmail(tokenEmail).orElseThrow(
                () -> new RecordNotFoundException(UsersEnum.USER_NOT_FOUND_EXCEPTION.getMessage())
        );

        String password = userPutRequestDTO.getPassword();

        if(password != null && !password.isEmpty()) {
          userPutRequestDTO.setPassword(passwordEncoder.encode(password));
        } else {
            userPutRequestDTO.setPassword(user.getPassword());
        }

        User userToBeUpdated = modelMapper.map(userPutRequestDTO, User.class);
        userToBeUpdated.setEmail(tokenEmail);
        userRepository.save(userToBeUpdated);
    }

    public void deleteUser(String token) {
        userRepository.deleteById(getUser(token).getId());
    }
}
