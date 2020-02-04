package com.example.successboardservice.web.rest;


import com.example.successboardservice.service.ResolutionCommunicatorService;
import com.example.successboardservice.web.model.ResolutionItem;
import com.example.successboardservice.web.model.UserResolutionItem;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        List<ResolutionItem> resolutionList = resolutionCommunicatorService.findAllResolutions();
        model.addAttribute("resolutionList", resolutionList);
        return "home";
    }

    @GetMapping("/new")
    public String createNewResolution(Model model){
        /*ResolutionItem resolutionItem = resolutionCommunicatorService.createNewResolution();*/
        ResolutionItem resolutionItem = new ResolutionItem();
        model.addAttribute("resolutionItem", resolutionItem);
        return "new_resolution";
    }

    @PostMapping("/save")
    public String saveResolution(@ModelAttribute("resolutionItem") ResolutionItem resolutionItem) {
        resolutionCommunicatorService.saveResolutionItem(resolutionItem);

        return "redirect:/resolutionuser";
    }

    /*@GetMapping("/resolutionuser/{userId}")
    public String findRatingById(@PathVariable("userId") String userId) {
        return resolutionCommunicatorService.findResolutionsByUser(userId);

    }*/
}

