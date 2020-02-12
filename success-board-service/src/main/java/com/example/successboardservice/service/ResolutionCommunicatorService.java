package com.example.successboardservice.service;

import com.example.successboardservice.web.model.ResolutionItem;
import com.example.successboardservice.web.model.ResolutionUser;
import com.example.successboardservice.web.model.UserResolutionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResolutionCommunicatorService implements ResolutionCommunicatorServiceInterface {

    @Autowired
    private final RestTemplate template;

    public ResolutionCommunicatorService() {
        this.template = new RestTemplate();
    }

    @Override
    public List<ResolutionItem> findAllResolutions() {
        final String requestUrl = "http://todo-board-service" + "/todoresolutions";
        final List<ResolutionItem> response = this.template.getForObject(requestUrl, List.class);

        return response;
    }

    @Override
    public List<ResolutionItem> findResolutionsByUser(Integer userId) {
        final String requestUrl = "http://todo-board-service" + "/todoresolutions/" + userId;
        final List<ResolutionItem> response = this.template.getForObject(requestUrl, List.class);

        return response;
    }

    @Override
    public List<UserResolutionItem> getUserResolutions() {
        final String requestUrl = "http://todo-board-service" + "/todoresolutions";
        List<ResolutionItem> iteml = this.template.getForObject(requestUrl, List.class);
        return iteml.stream()
                .map(items -> {
                    ResolutionUser resolutionUser = this.template.getForObject("http://resolutionUser-service/users/" + items.getUserId(), ResolutionUser.class);
                    return new UserResolutionItem(items.getTitle(), items.getDescription(), items.getStatus(), resolutionUser.getResUserName());
                })
                .collect(Collectors.toList());
    }

    @Override
    public ResolutionItem saveResolutionItem(ResolutionItem resolutionItem) {
        final String requestUrl = "http://todo-board-service" + "/todoresolutions/create";
        final ResolutionItem response = this.template.postForObject(requestUrl, resolutionItem, ResolutionItem.class);
        return response;
    }

    @Override
    public List<ResolutionUser> findAllUser() {
        final String requestUrl = "http://resolutionUser-service" + "/users";
        final List<ResolutionUser> response = this.template.getForObject(requestUrl, List.class);
        return response;
    }

    @Override
    public ResolutionUser saveUser(ResolutionUser resolutionUser) {
        final String requestUrl = "http://resolutionUser-service" + "/users/add";
        final ResolutionUser response = this.template.postForObject(requestUrl, resolutionUser, ResolutionUser.class);
        return response;
    }

    @Override
    public ResolutionUser deleteUser(Integer userId) {
        final String requestUrl = "http://resolutionUser-service" + "/users/delete/" + userId;
        final ResponseEntity<ResolutionUser> response = this.template.exchange(requestUrl, HttpMethod.DELETE, null, ResolutionUser.class);
        return response.getBody();
    }

    @Override
    public ResolutionItem get(Integer itemId) {
        final String requestUrl = "http://todo-board-service" + "/resolutions/"+ itemId;
        final ResolutionItem response = this.template.getForObject(requestUrl, ResolutionItem.class);
        return response;
    }

    @Override
    public ResolutionItem deleteResolutionItem(Integer itemId) {
        final String requestUrl = "http://todo-board-service" + "/delete/"+ itemId;
        final ResponseEntity<ResolutionItem> response = this.template.exchange(requestUrl, HttpMethod.DELETE, null, ResolutionItem.class);
        return response.getBody();
    }
}
