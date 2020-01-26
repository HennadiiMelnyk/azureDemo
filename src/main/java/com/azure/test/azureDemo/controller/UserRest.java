package com.azure.test.azureDemo.controller;

import com.azure.test.azureDemo.service.UserService;
import org.springframework.web.bind.annotation.RestController;

/**
 * User rest controller
 */
@RestController
public class UserRest {

    private UserService userService;
}
