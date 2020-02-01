package com.example.todoboardservice.web.rest;

import com.example.todoboardservice.service.ResolutionItemService;
import com.example.todoboardservice.web.model.ResolutionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/todoresolutions")
public class TodoListController {

    @Autowired
    private ResolutionItemService resolutionItemService;

    @RequestMapping("/{userId}")
    public List<ResolutionItem> getTodoList(@PathVariable("userId") String userId) {
        return resolutionItemService.getTodoList(userId);
    }

    @RequestMapping("/{userId}/{itemId}")
    public ResolutionItem getResolutionItem(@PathVariable("userId") String userId, @PathVariable("itemId")String itemId){
        return resolutionItemService.getResolutionItem(userId, itemId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{userId}")
    public void addResolutionItem(@RequestBody ResolutionItem resolutionItem){
        resolutionItemService.addResolutionItem(resolutionItem);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{userId}/{itemId}")
    public void updateResolutionItem(@RequestBody ResolutionItem resolutionItem, @PathVariable("itemId")String itemId, @PathVariable("userId") String userId){
        resolutionItemService.updateResolutionItem(userId, itemId, resolutionItem);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{userId}/{itemId}")
    public void deleteResolutionItem(@PathVariable("userId") String userId, @PathVariable("itemId")String itemId){
        resolutionItemService.deleteResolutionItem(userId, itemId);
    }

}
