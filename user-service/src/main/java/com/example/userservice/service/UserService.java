package com.example.userservice.service;

import com.example.userservice.mysql.repository.UserRepository;
import com.example.userservice.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    /*private List<User> userList= new ArrayList<>(Arrays.asList(
            new User("01", "Anakin"),
            new User("02", "Obi Wan"),
            new User("03", "Leia"),
            new User("04", "Luke")
    ));*/

    public List<User> getUserList() {
        List<User> userList  = new ArrayList<>();
        userRepository.findAll()
                .forEach (userList::add);
        return userList;
    }

    public Optional<User> getUser(String userId){
        return userRepository.findById(userId);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(String userId, User user) {
       /* for (int i = 0; i < userList.size(); i++){
            User r = userList.get(i);
            if(r.getUserId().equals(userId)){
                userList.set(i, user);
                return;
            }
        }*/
       userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    /*public List<ResolutionItem> getUserResolutions(String userId) {
        RestTemplate restTemplate = new RestTemplate();
        ResolutionItem resolutionItem = restTemplate.getForObject("http://localhost:8082/todoresolutions/" + userId, ResolutionItem.class);
        return resolutionItem.getItemId().;
    }*/
}
