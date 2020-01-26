package com.azure.test.azureDemo.controller;

import com.azure.test.azureDemo.domain.User;
import com.azure.test.azureDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * User rest controller
 */
@RestController
public class UserRest {

    private UserService userService;

    @Autowired
    public UserRest(UserService userService) {
        this.userService = userService;
    }

    /**
     *
     * @return
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /**
     *
     * @param user
     * @return
     */
    @PostMapping("user")
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        User userEntity = userService.createUser(user);
        return ResponseEntity.ok(userEntity);
    }
}
