package com.example.userservice.web.rest;

import com.example.userservice.service.UserService;
import com.example.userservice.web.model.ResolutionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<ResolutionUser> getUserList() {
        return userService.getUserList();
    }

    @RequestMapping("/users/{userId}")
    public Optional<ResolutionUser> getUser(@PathVariable("userId") Integer userId){
        return userService.getUser(userId);
    }

    /*@RequestMapping("/users/{userId}")
    public List<ResolutionItem> getUserResolutions(@PathVariable("userId") String userId){
        return userService.getUserResolutions(userId);
    }*/

    @RequestMapping(method = RequestMethod.POST, value = "/users/add")
    public void addUser(@RequestBody ResolutionUser resolutionUser){
        userService.addUser(resolutionUser);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/update/{userId}")
    public void updateResolutionItem(@RequestBody ResolutionUser resolutionUser, @PathVariable("userId") Integer userId){
        userService.updateUser(userId, resolutionUser);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/delete/{userId}")
    public void deleteResolutionItem(@PathVariable("userId") Integer userId){
        userService.deleteUser(userId);
    }


}
