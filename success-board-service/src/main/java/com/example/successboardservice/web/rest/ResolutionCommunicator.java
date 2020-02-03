package com.example.successboardservice.web.rest;


import com.example.successboardservice.service.ResolutionCommunicatorService;
import com.example.successboardservice.web.model.ResolutionItem;
import com.example.successboardservice.web.model.UserResolutionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class ResolutionCommunicator {

    @Autowired
    private ResolutionCommunicatorService resolutionCommunicatorService;


   /* @GetMapping("/resolutionuser")
    public String findAllResolutions(Model model) {
        List<ResolutionItem> resolutionList = resolutionCommunicatorService.findAllResolutions();
        model.addAttribute("resolutionList", resolutionList);
        return "home";

    }*/

    @GetMapping("/resolutionuser")
    public String findAllResolutions(Model model) {
        List<UserResolutionItem> resolutionList = resolutionCommunicatorService.getUserResolutions();
        model.addAttribute("resolutionList", resolutionList);
        return "home";

    }
    /*@GetMapping("/resolutionuser/{userId}")
    public String findRatingById(@PathVariable("userId") String userId) {
        return resolutionCommunicatorService.findResolutionsByUser(userId);

    }*/
}

