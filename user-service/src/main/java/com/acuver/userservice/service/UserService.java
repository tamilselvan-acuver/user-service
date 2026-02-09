package com.acuver.userservice.service;

import com.acuver.userservice.entity.User;
import com.acuver.userservice.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> getAllUsers();


    User getUserById(Long id) throws UserNotFoundException;

    User updateUser(User user, Long id) throws UserNotFoundException;

    void deleteUserById(Long id) throws UserNotFoundException;
}
