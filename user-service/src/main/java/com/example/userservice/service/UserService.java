package com.example.userservice.service;

import com.example.userservice.mysql.repository.UserRepository;
import com.example.userservice.web.model.ResolutionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<ResolutionUser> getUserList() {
        List<ResolutionUser> resolutionUserList = new ArrayList<>();
        userRepository.findAll()
                .forEach (resolutionUserList::add);
        return resolutionUserList;
    }

    public Optional<ResolutionUser> getUser(Integer userId){
        return userRepository.findById(userId);
    }

    public void addUser(ResolutionUser resolutionUser) {
        userRepository.save(resolutionUser);
    }

    public void updateUser(Integer userId, ResolutionUser resolutionUser) {
       /* for (int i = 0; i < userList.size(); i++){
            ResolutionUser r = userList.get(i);
            if(r.getUserId().equals(userId)){
                userList.set(i, resolutionUser);
                return;
            }
        }*/
       userRepository.save(resolutionUser);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    /*public List<ResolutionItem> getUserResolutions(String userId) {
        RestTemplate restTemplate = new RestTemplate();
        ResolutionItem resolutionItem = restTemplate.getForObject("http://localhost:8082/todoresolutions/" + userId, ResolutionItem.class);
        return resolutionItem.getItemId().;
    }*/
}
