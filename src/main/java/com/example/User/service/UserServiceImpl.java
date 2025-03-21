package com.example.User.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.User.entity.User;

@Service
public class UserServiceImpl {


    @Autowired
    private UserRepository userRepository; // ✅ Connect to PostgreSQL database

    // ✅ Create a new user and store it in the database
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // ✅ Update an existing user by ID
    public User updateUser(int id, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }

    // ✅ Delete a user by ID
    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "User deleted successfully";
    }

    // ✅ Get all users from the database
    public List<User> getUser() {
        return userRepository.findAll();
    }

}