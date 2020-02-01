package com.example.todoboardservice.web.rest;

import com.example.todoboardservice.service.ResolutionItemService;
import com.example.todoboardservice.web.model.ResolutionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        return new ResolutionItem(itemId, "Vorsatz 1", "Beschreibung Vorsatz 1", "todo", userId);
    }

}
