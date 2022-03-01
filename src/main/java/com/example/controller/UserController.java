package com.example.controller;

import com.example.entity.User;
import com.example.model.validation.UserValid;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody @Valid UserValid user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(user));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@RequestBody @Valid UserValid userForm, @PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userForm, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
    }
}
