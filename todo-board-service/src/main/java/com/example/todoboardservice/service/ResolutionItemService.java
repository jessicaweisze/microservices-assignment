package com.example.todoboardservice.service;

import com.example.todoboardservice.web.model.ResolutionItem;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Service
public class ResolutionItemService {

    private List<ResolutionItem> toDoList= Arrays.asList(
            new ResolutionItem("1", "Mehr Sachen selber nähen", "mind. 3 Kleider, 2 Tshirts und eine Tasche", "todo", "01"),
            new ResolutionItem("2", "Mehr lesen", "mind. 5 Bücker lesen", "todo", "01"),
            new ResolutionItem("3", "Mehr Sport machen", "mind. 2 mal pro Woche Sport machen", "todo", "01"),
            new ResolutionItem("4", "Mehr Vielfalt beim Keksebacken", "Auch mal Alpakakekse backen", "todo", "01")
    );

    public List<ResolutionItem> getTodoList(@PathVariable("userId") String userId) {
        return toDoList;
    }

    public ResolutionItem getResolutionItem(@PathVariable("userId") String userId, @PathVariable("itemId")String itemId){
        return toDoList.stream().filter(r ->
                r.getUserId().equals(userId)).findFirst().get();
    }
}