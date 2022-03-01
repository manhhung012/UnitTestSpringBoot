package com.example.model.mapper;

import com.example.entity.User;
import com.example.model.dto.UserDto;
import com.example.model.validation.UserValid;

public class UserMapper {
    public static UserDto userToDto(User user) {
        UserDto u = new UserDto();
        u.setId(user.getId());
        u.setFullName(user.getFullName());
        u.setPhone(user.getPhone());

        return u;
    }

    public static User userFromValid(UserValid userValid) {
        User u = new User();
        u.setId(userValid.getId());
        u.setFullName(userValid.getFullName());
        u.setPhone(userValid.getPhone());
        u.setUserName(userValid.getUserName());
        u.setPassword(userValid.getPassword());

        return u;
    }
}
