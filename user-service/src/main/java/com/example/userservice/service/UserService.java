package com.example.userservice.service;

import com.example.userservice.web.model.ResolutionItem;
import com.example.userservice.web.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private List<User> userList= new ArrayList<>(Arrays.asList(
            new User("01", "Anakin"),
            new User("02", "Obi Wan"),
            new User("03", "Leia"),
            new User("04", "Luke")
    ));

    public List<User> getUserList() {
        return userList;
    }

    public User getUser(String userId){
        return userList.stream().filter(r ->
                r.getUserId().equals(userId)).findFirst().get();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void updateUser(String userId, User user) {
        for (int i = 0; i < userList.size(); i++){
            User r = userList.get(i);
            if(r.getUserId().equals(userId)){
                userList.set(i, user);
                return;
            }
        }
    }

    public void deleteUser(String userId) {
        userList.removeIf(r ->
                r.getUserId().equals(userId));
    }

    /*public List<ResolutionItem> getUserResolutions(String userId) {
        RestTemplate restTemplate = new RestTemplate();
        ResolutionItem resolutionItem = restTemplate.getForObject("http://localhost:8082/todoresolutions/" + userId, ResolutionItem.class);
        return resolutionItem.getItemId().;
    }*/
}
