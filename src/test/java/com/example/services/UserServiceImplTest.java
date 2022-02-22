package com.example.services;

import com.example.dao.UserDao;
import com.example.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class UserServiceImplTest {

    @Mock
    UserDao userDao;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void testGetAllUser() {
        List<User> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add(new User());
        }
        when(userDao.findAll()).thenReturn(data);

        List<User> result = userService.getAllUser();

        assertEquals(data.size(), result.size());

        verify(userDao).findAll();
    }

    @Test
    void getUserByIdWhenThereData() {
        User data = new User();

        when(userDao.findById(15)).thenReturn(Optional.of(data));

        Optional<User> result = userService.getUserById(15);

        assertEquals(Optional.of(data), result);

        verify(userDao).findById(15);
    }

    @Test
    void getUserByIdWhenCannotFindData() {
        when(userDao.findById(15)).thenReturn(Optional.empty());

        Optional<User> result = userService.getUserById(15);

        assertEquals(Optional.empty(), result);

        verify(userDao).findById(15);
    }

    @Test
    void testCreateUserWhenDuplicateFullName() {

        User u = new User();
        List<User> data = new ArrayList<>();
        data.add(new User());

        when(userDao.findByFullName(any())).thenReturn(data);

        String status = userService.createUser(u).getBody().getStatus();

        assertEquals("Failed", status);

        verify(userDao).findByFullName(any());
    }

    @Test
    void testCreateUserWhenNoFoundFullNameAndCreateNewUser() {

        User u = new User();

        when(userDao.findByFullName(any())).thenReturn(Collections.EMPTY_LIST);

        String result = userService.createUser(u).getBody().getStatus();

        assertEquals("OK", result);

        verify(userDao).findByFullName(any());
    }

    @Test
    void testUpdateUser() {
        User uF = new User();
        uF.setId(12);
        uF.setFullName("Hai");
        uF.setPhone("0817953779");

        User u = new User();
        u.setId(12);
        u.setFullName("Hung");
        u.setPhone("0825405779");

        when(userDao.findById(any())).thenReturn(Optional.of(u));

        String result = userService.updateUser(uF, 12).getBody().getStatus();

        assertEquals("OK", result);

        verify(userDao).findById(12);
    }

    @Test
    void testDeleteUserSuccessfully() {
        when(userDao.existsById(any())).thenReturn(true);

        String result = userService.deleteUser(any()).getBody().getStatus();

        assertEquals("OK", result);

        verify(userDao).existsById(any());
    }

    @Test
    void testDeleteUserWhenCannotFindUser() {
        when(userDao.existsById(any())).thenReturn(false);

        String result = userService.deleteUser(any()).getBody().getStatus();

        assertEquals("Failed", result);

        verify(userDao).existsById(any());
    }
}