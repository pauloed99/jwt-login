package com.api.jwtlogin.services;

import com.api.jwtlogin.dtos.UserPostRequestDTO;
import com.api.jwtlogin.dtos.UserPutRequestDTO;
import com.api.jwtlogin.dtos.UserResponseDTO;
import com.api.jwtlogin.enums.UsersEnum;
import com.api.jwtlogin.exceptions.BadRequestException;
import com.api.jwtlogin.exceptions.RecordNotFoundException;
import com.api.jwtlogin.models.User;
import com.api.jwtlogin.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserResponseDTO getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException(UsersEnum.USER_NOT_FOUND_EXCEPTION.getMessage())
        );
        return modelMapper.map(user, UserResponseDTO.class);
    }

    public void updateUser(UserPutRequestDTO userPutRequestDTO) {
        getUser(userPutRequestDTO.getId());
        User userToBeUpdated = modelMapper.map(userPutRequestDTO, User.class);
        userRepository.save(userToBeUpdated);
    }

    public void deleteUser(Long id) {
        getUser(id);
        userRepository.deleteById(id);
    }
}
