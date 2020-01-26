package com.azure.test.azureDemo.service;

import com.azure.test.azureDemo.domain.User;

import java.util.List;

/**
 * User Service
 */
public interface UserService {
    /**
     * @param email
     * @return
     */
    User getUserByEmail(String email);

    /**
     * @return
     */
    List<User> getAllUsers();

    /**
     * @param email
     * @return
     */
    String getPasswordByEmail(String email);


}
