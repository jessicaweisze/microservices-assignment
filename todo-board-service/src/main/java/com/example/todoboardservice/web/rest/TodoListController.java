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
        return Arrays.asList(
                new ResolutionItem("1", "Mehr Sachen selber nähen", "mind. 3 Kleider, 2 Tshirts und eine Tasche", "todo", "01"),
                new ResolutionItem("2", "Mehr lesen", "mind. 5 Bücker lesen", "todo", "01"),
                new ResolutionItem("3", "Mehr Sport machen", "mind. 2 mal pro Woche Sport machen", "todo", "01"),
                new ResolutionItem("4", "Mehr Vielfalt beim Keksebacken", "Auch mal Alpakakekse backen", "todo", "01")
                );
    }

    @RequestMapping("/{userId}/{itemId}")
    public ResolutionItem getResolutionItem(@PathVariable("itemId")String itemId){
        return new ResolutionItem(itemId, "Vorsatz 1", "Beschreibung Vorsatz 1", "todo", "01");
    }
}
