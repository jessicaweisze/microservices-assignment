package com.example.successboardservice.service;

import com.example.successboardservice.web.model.ResolutionItem;
import com.example.successboardservice.web.model.ResolutionUser;
import com.example.successboardservice.web.model.UserResolutionItem;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResolutionCommunicatorService {
    private final RestTemplate template;
    //private final String url;

    public ResolutionCommunicatorService(/*@Value("${remote.service.ratingservice.url}") String url*/) {
        this.template = new RestTemplate();
        //this.url = url;
    }

    public List<ResolutionItem> findAllResolutions() {
        final String requestUrl = "http://localhost:8082" + "/todoresolutions";
        final List<ResolutionItem> response = this.template.getForObject(requestUrl, List.class);

        return response;
    }

    public String findResolutionsByUser(String userId) {
        final String requestUrl = "http://localhost:8082" + "/todoresolutions/" + userId;
        final String response = this.template.getForObject(requestUrl, String.class);

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

    /*public ResolutionItem createNewResolution() {
        final String requestUrl = "http://localhost:8082" + "/todoresolutions/create";
        final ResolutionItem response = this.template.getForObject(requestUrl, ResolutionItem.class);
        return response;
    }*/

    @HystrixCommand(fallbackMethod = "showFallBack")
    public ResolutionItem saveResolutionItem(ResolutionItem resolutionItem) {
        final String requestUrl = "http://localhost:8082" + "/todoresolutions/create";
        final ResolutionItem response = this.template.postForObject(requestUrl, resolutionItem, ResolutionItem.class);
        return response;
    }

    private String showFallBack() {
        return "Der Service ist gerade leider nicht erreichbar! Versuche es später erneut!";
    }

    /*public List<UserResolutionItem> getUserResolutions() {
        final String requestUrl = "http://localhost:8082" + "/todoresolutions";
        List<ResolutionItem> iteml = this.template.getForObject(requestUrl, List.class);
        List<ResolutionUser> ruser = this.template.getForObject("http://localhost:8083/users/" + iteml.stream()., List.class);
        return iteml.stream()
                .map(items -> {
                    ResolutionUser resolutionUser = this.template.getForObject("http://localhost:8083/users/" + items.getUserId(), ResolutionUser.class);
                    return new UserResolutionItem(items.getTitle(), items.getDescription(), items.getStatus(), resolutionUser.getResUserName());
                })
                .collect(Collectors.toList());
    }*/



}
