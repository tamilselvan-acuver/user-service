package com.acuver.userservice.controller;

import com.acuver.userservice.entity.User;
import com.acuver.userservice.exception.UserNotFoundException;
import com.acuver.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String helloUser(){
        return "User service is running.";
    }

    // create user
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    // Read all users
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    // Read User by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    // update user
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") Long id) throws UserNotFoundException {
        return userService.updateUser(user, id);
    }

    // delete User
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) throws UserNotFoundException {
        userService.deleteUserById(id);
    }


}
