package com.example.userservice.service;

import com.example.userservice.web.model.ResolutionItem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ResolutionCommunicatorService {
    private final RestTemplate template;
    //private final String url;

    public ResolutionCommunicatorService(/*@Value("${remote.service.ratingservice.url}") String url*/) {
        this.template = new RestTemplate();
        //this.url = url;
    }

    public String findResolutionsByUser() {
        final String requestUrl = "http://localhost:8082" + "/todoresolutions";
        final String response = this.template.getForObject(requestUrl, String.class);

        return response;
    }

    public List<ResolutionItem> findAllResolutions() {
        final String requestUrl = "http://localhost:8082" + "/todoresolutions";
        final List<ResolutionItem> response = this.template.getForObject(requestUrl, List.class);

        return response;
    }

}
