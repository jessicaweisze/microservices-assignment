package com.example.successboardservice.web.rest;


import com.example.successboardservice.service.ResolutionCommunicatorService;
import com.example.successboardservice.web.model.ResolutionItem;
import com.example.successboardservice.web.model.ResolutionUser;
import com.example.successboardservice.web.model.UserResolutionItem;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ResolutionCommunicator {

    @Autowired
    private ResolutionCommunicatorService resolutionCommunicatorService;

    @GetMapping("/resolutionuser")
    public String showAllUser(Model model){
        List<ResolutionUser> resolutionUser = resolutionCommunicatorService.findAllUser();
        model.addAttribute("resolutionUser", resolutionUser);
        return "user";
    }

    private String getSaveFallback(Model model) {
        return "fallback";
    }
    @GetMapping("/resolutionuser/createUser")
    public String createNewUser(Model model){
        ResolutionUser resolutionUser = new ResolutionUser();
        model.addAttribute("resolutionUser", resolutionUser);
        return "new_user";
    }

    @PostMapping("/resolutionuser/saveUser")
    public String saveNewUser(@ModelAttribute("resolutionUser") ResolutionUser resolutionUser){
        resolutionCommunicatorService.saveUser(resolutionUser);
        return "redirect:/resolutionuser";
    }

    @HystrixCommand(fallbackMethod = "getSaveFallback")
    @GetMapping("/resolutionuser/all")
    public String findAllResolutions(Model model) {
        List<ResolutionItem> resolutionList = resolutionCommunicatorService.findAllResolutions();
        model.addAttribute("resolutionList", resolutionList);
        return "home";
    }

    @GetMapping("/resolutionuser/create")
    public String createNewResolution(Model model){
        ResolutionItem resolutionItem = new ResolutionItem();
        model.addAttribute("resolutionItem", resolutionItem);
        return "new_resolution";
    }

    @PostMapping("/resolutionuser/save")
    public String saveResolution(@ModelAttribute("resolutionItem") ResolutionItem resolutionItem) {
        resolutionCommunicatorService.saveResolutionItem(resolutionItem);
        return "redirect:/resolutionuser";
    }

    @GetMapping("/resolutionuser/{userId}")
    public String findRatingById(@PathVariable("userId") Integer userId, Model model) {
        List<ResolutionItem> userResolutions = resolutionCommunicatorService.findResolutionsByUser(userId);
        model.addAttribute("userResolutions", userResolutions);
        return "user_resolutions";
    }

    @RequestMapping("/resolutionuser/update/{itemId}")
    public ModelAndView showEditProductPage(@PathVariable("itemId") Integer itemId) {
        ModelAndView mav = new ModelAndView("edit_resolution");
        ResolutionItem resolutionItem = resolutionCommunicatorService.get(itemId);
        mav.addObject("resolutionItem", resolutionItem);

        return mav;
    }

    @GetMapping("/resolutionuser/delete/{itemId}")
    public String deleteItem(@PathVariable("itemId") Integer itemId, HttpServletRequest request) {
        resolutionCommunicatorService.deleteResolutionItem(itemId);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

    @GetMapping("/resolutionuser/deleteUser/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId, HttpServletRequest request) {
        resolutionCommunicatorService.deleteUser(userId);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

}

