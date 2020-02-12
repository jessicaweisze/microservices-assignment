package com.example.userservice.service;

import com.example.userservice.web.model.ResolutionUser;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {

    public List<ResolutionUser> getUserList();

    public Optional<ResolutionUser> getUser(Integer userId);

    public void addUser(ResolutionUser resolutionUser);

    public void updateUser(Integer userId, ResolutionUser resolutionUser);

    public void deleteUser(Integer userId);
}
