package com.azure.test.azureDemo.service.impl;

import com.azure.test.azureDemo.domain.Role;
import com.azure.test.azureDemo.domain.User;
import com.azure.test.azureDemo.domain.UserStatus;
import com.azure.test.azureDemo.exception.ResourceNotFoundException;
import com.azure.test.azureDemo.persistence.UserRepository;
import com.azure.test.azureDemo.service.UserService;
import com.azure.test.azureDemo.utils.IdGeneratorUtils;
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
    public User createUser(User userEntity) {
        System.out.println(userEntity.toString());
        userEntity.setId(IdGeneratorUtils.generateUUID());
        userEntity.setRole(Role.valueOf(String.valueOf(Role.User)));
        userEntity.setStatus(UserStatus.Active);
        return userRepository.save(userEntity);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User doesn't exist with id: " + id));
    }
}
