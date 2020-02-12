package com.example.userservice.service;

import com.example.userservice.mysql.repository.UserRepository;
import com.example.userservice.web.model.ResolutionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<ResolutionUser> getUserList() {
        List<ResolutionUser> resolutionUserList = new ArrayList<>();
        userRepository.findAll()
                .forEach (resolutionUserList::add);
        return resolutionUserList;
    }

    @Override
    public Optional<ResolutionUser> getUser(Integer userId){
        return userRepository.findById(userId);
    }

    @Override
    public void addUser(ResolutionUser resolutionUser) {
        userRepository.save(resolutionUser);
    }

    @Override
    public void updateUser(Integer userId, ResolutionUser resolutionUser) {
       userRepository.save(resolutionUser);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
