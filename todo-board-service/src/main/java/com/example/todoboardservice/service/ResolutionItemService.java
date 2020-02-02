package com.example.todoboardservice.service;

import com.example.todoboardservice.mysql.repository.ResolutionItemRepository;
import com.example.todoboardservice.web.model.ResolutionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ResolutionItemService {

    @Autowired
    private ResolutionItemRepository resolutionItemRepository;

    private List<ResolutionItem> toDoList= new ArrayList<>(Arrays.asList(
            new ResolutionItem("1", "Mehr Sachen selber nähen", "mind. 3 Kleider, 2 Tshirts und eine Tasche", "todo", "01"),
            new ResolutionItem("2", "Mehr lesen", "mind. 5 Bücker lesen", "todo", "02"),
            new ResolutionItem("3", "Mehr Sport machen", "mind. 2 mal pro Woche Sport machen", "todo", "01"),
            new ResolutionItem("4", "Mehr Vielfalt beim Keksebacken", "Auch mal Alpakakekse backen", "todo", "02")
    ));

    public List<ResolutionItem> getTodoList() {
        List<ResolutionItem> todoList  = new ArrayList<>();
        resolutionItemRepository.findAll()
        .forEach (todoList::add);
        return todoList;
    }

    public Optional<ResolutionItem> getResolutionItem(String itemId){
        return resolutionItemRepository.findById(itemId);
    }

    public void addResolutionItem(ResolutionItem resolutionItem) {
        resolutionItemRepository.save(resolutionItem);
    }

    public void updateResolutionItem(String userId, String itemId, ResolutionItem resolutionItem) {
        /*for (int i = 0; i < toDoList.size(); i++){
            ResolutionItem r = toDoList.get(i);
            if(r.getItemId().equals(itemId) & r.getUserId().equals(userId)){
                toDoList.set(i, resolutionItem);
                return;
            }
        }*/
        resolutionItemRepository.save(resolutionItem);
    }

    public void patchStatusToDone(String userId, String itemId, ResolutionItem resolutionItem) {
        for (int i = 0; i < toDoList.size(); i++){
            ResolutionItem r = toDoList.get(i);
            if(r.getItemId().equals(itemId) & r.getUserId().equals(userId)){
                r.setStatus("done");
            }
        }
    }

    public void deleteResolutionItem(String userId, String itemId) {
       /* toDoList.removeIf(r ->
                r.getUserId().equals(userId) & r.getItemId().equals(itemId));*/
       resolutionItemRepository.deleteById(itemId);
    }
}