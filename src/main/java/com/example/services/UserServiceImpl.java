package com.example.services;

import com.example.dao.UserDao;
import com.example.exception.FailedException;
import com.example.exception.NotFoundException;
import com.example.entity.User;
import com.example.model.dto.UserDto;
import com.example.model.mapper.UserMapper;
import com.example.model.validation.UserValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<UserDto> getAllUser() {
        List<UserDto> listUserDto = new ArrayList<>();
        List<User> listUser = userDao.findAll();
        for (User u : listUser) {
            UserDto uD = UserMapper.userToDto(u);
            listUserDto.add(uD);
        }
        return listUserDto;
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public String createUser(UserValid userValid) {
        Optional<User> checkId = userDao.findById(userValid.getId());
        if (!checkId.isPresent()) {
            UserMapper.userToDto(userDao.save(UserMapper.userFromValid(userValid)));
            return "Create user successfully";
        } else {
            throw new NotFoundException("Id user already taken");
        }
    }

    @Override
    public String updateUser(UserValid userForm, Integer id) {
        userDao.findById(id).map(user -> {
                    user.setFullName(userForm.getFullName());
                    user.setPhone(userForm.getPhone());
                    userDao.save(user);
                    return "Update user successfully";
                })
                .orElseGet(() -> {
                    userForm.setId(id);
                    userDao.save(UserMapper.userFromValid(userForm));
                    return "Insert user successfully";
                });
        throw new FailedException("Failed query");
    }

    @Override
    public String deleteUser(Integer id) {
        boolean exists = userDao.existsById(id);
        if (exists) {
            return "Delete User successfully";
        } else {
            throw new NotFoundException("Cannot find User to delete");
        }
    }
}
