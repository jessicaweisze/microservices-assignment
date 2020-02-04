package com.example.successboardservice.service;

import com.example.successboardservice.web.model.ResolutionItem;
import com.example.successboardservice.web.model.ResolutionUser;
import com.example.successboardservice.web.model.UserResolutionItem;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResolutionCommunicatorService {
    private final RestTemplate template;
    //private final String url;

    public ResolutionCommunicatorService() {
        this.template = new RestTemplate();
        //this.url = url;
    }
    public List<ResolutionItem> findAllResolutions() {
        final String requestUrl = "http://localhost:8082" + "/todoresolutions";
        final List<ResolutionItem> response = this.template.getForObject(requestUrl, List.class);

        return response;
    }

    public List<ResolutionItem> findResolutionsByUser(Integer userId) {
        final String requestUrl = "http://localhost:8082" + "/todoresolutions/" + userId;
        final List<ResolutionItem> response = this.template.getForObject(requestUrl, List.class);

        return response;
    }

    public List<UserResolutionItem> getUserResolutions() {
        final String requestUrl = "http://localhost:8082" + "/todoresolutions";
        List<ResolutionItem> iteml = this.template.getForObject(requestUrl, List.class);
        return iteml.stream()
                .map(items -> {
                    ResolutionUser resolutionUser = this.template.getForObject("http://localhost:8083/users/" + items.getUserId(), ResolutionUser.class);
                    return new UserResolutionItem(items.getTitle(), items.getDescription(), items.getStatus(), resolutionUser.getResUserName());
                })
                .collect(Collectors.toList());
    }

    public ResolutionItem saveResolutionItem(ResolutionItem resolutionItem) {
        final String requestUrl = "http://localhost:8082" + "/todoresolutions/create";
        final ResolutionItem response = this.template.postForObject(requestUrl, resolutionItem, ResolutionItem.class);
        return response;
    }

    public List<ResolutionUser> findAllUser() {
        final String requestUrl = "http://localhost:8083" + "/users";
        final List<ResolutionUser> response = this.template.getForObject(requestUrl, List.class);
        return response;

    }
    public ResolutionUser saveUser(ResolutionUser resolutionUser) {
        final String requestUrl = "http://localhost:8083" + "/users/add";
        final ResolutionUser response = this.template.postForObject(requestUrl, resolutionUser, ResolutionUser.class);
        return response;
    }

    public ResolutionUser deleteUser(Integer userId) {
        final String requestUrl = "http://localhost:8083" + "/users/delete/" + userId;
        final ResponseEntity<ResolutionUser> response = this.template.exchange(requestUrl, HttpMethod.DELETE, null, ResolutionUser.class);
        return response.getBody();
    }

    public ResolutionItem get(Integer itemId) {
        final String requestUrl = "http://localhost:8082" + "/resolutions/"+ itemId;
        final ResolutionItem response = this.template.getForObject(requestUrl, ResolutionItem.class);
        return response;
    }

    public ResolutionItem deleteResolutionItem(Integer itemId) {
        final String requestUrl = "http://localhost:8082" + "/delete/"+ itemId;
        final ResponseEntity<ResolutionItem> response = this.template.exchange(requestUrl, HttpMethod.DELETE, null, ResolutionItem.class);
        return response.getBody();
    }
}
