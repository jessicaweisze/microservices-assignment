package com.example.userservice.web.rest;

import com.example.userservice.service.UserService;
import com.example.userservice.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/users")
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @RequestMapping("/users/{userId}")
    public User getUser(@PathVariable("userId") String userId){
        return userService.getUser(userId);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/users/{userId}")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}")
    public void updateResolutionItem(@RequestBody User user, @PathVariable("userId") String userId){
        userService.updateUser(userId, user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
    public void deleteResolutionItem(@PathVariable("userId") String userId){
        userService.deleteUser(userId);
    }


}
