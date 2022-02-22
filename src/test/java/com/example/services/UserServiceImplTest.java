package com.example.services;

import com.example.dao.UserDao;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;

    @MockBean
    UserDao dao;

    @Test
    void getAllUser() {
        Assert.assertEquals(0, userService.getAllUser().size());
    }

    @Test
    void getUserById() {
        Assert.assertNotNull(userService.getUserById(30));
    }

    @Test
    void createUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}