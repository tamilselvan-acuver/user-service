package com.acuver.userservice.serviceImpl;

import com.acuver.userservice.entity.User;
import com.acuver.userservice.exception.UserNotFoundException;
import com.acuver.userservice.repository.UserRepository;
import com.acuver.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.ObjectName;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found with id: " + id));
    }

    @Override
    public User updateUser(User user, Long id) throws UserNotFoundException {

        User existingUser = getUserById(id);

        if(Objects.nonNull(user.getUserName()) && !"".equals(user.getUserName())){
            existingUser.setUserName(user.getUserName());
        }

        if(Objects.nonNull(user.getEmail()) && !"".equals(user.getEmail())){
            existingUser.setUserName(user.getEmail());
        }

        if(Objects.nonNull(user.getPassword()) && !"".equals(user.getPassword())){
            existingUser.setPassword(user.getPassword());
        }

        return userRepository.save(existingUser);



    }

    @Override
    public void deleteUserById(Long id) throws UserNotFoundException {
        User existingUser = getUserById(id);

        userRepository.deleteById(id);
    }
}
