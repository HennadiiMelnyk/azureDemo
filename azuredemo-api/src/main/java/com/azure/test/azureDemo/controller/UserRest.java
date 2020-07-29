package com.azure.test.azureDemo.controller;

import com.azure.test.azureDemo.domain.User;
import com.azure.test.azureDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.DataInput;
import java.io.IOException;
import java.util.List;

/**
 * User rest controller
 */
@RestController
@Validated
public class UserRest {

    private UserService userService;

    @Autowired
    public UserRest(UserService userService) {
        this.userService = userService;
    }

    /**
     * @return
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     * @param user
     * @return
     */
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> create(@Valid @RequestBody User user)  {
        User userEntity = userService.createUser(user);

        return ResponseEntity.ok(userEntity);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(String userId) {
        User userEntity = userService.getUserById(userId);
        return ResponseEntity.ok(userEntity);
    }
}
