package com.example.services;

import com.example.entity.User;
import com.example.model.dto.UserDto;
import com.example.model.validation.UserValid;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> getAllUser();

    Optional<User> getUserById(Integer id);

    String createUser(UserValid user);

    String updateUser(UserValid userForm, Integer id);

    String deleteUser(Integer id);

}
