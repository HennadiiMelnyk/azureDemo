package com.azure.test.azureDemo.service.impl;

import com.azure.test.azureDemo.domain.User;
import com.azure.test.azureDemo.exception.ResourceNotFoundException;
import com.azure.test.azureDemo.persistence.UserRepository;
import com.azure.test.azureDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("user with this email din't find"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String getPasswordByEmail(String email) {
        return null;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
