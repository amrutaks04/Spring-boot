package com.example.User.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.User.entity.User;
import java.util.List;

import com.example.User.service.UserServiceImpl;


@RestController
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping(value = "/user/create")
    public User createUser(@RequestBody User user) {
        return userServiceImpl.createUser(user);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User userDetails) {
        return userServiceImpl.updateUser(id, userDetails);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return userServiceImpl.deleteUser(id);
    }

    @GetMapping(value = "/user/details")
    public List<User> getUser()
    {
        return userServiceImpl.getUser();
    }

}
