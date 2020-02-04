package com.example.todoboardservice.service;

import com.example.todoboardservice.mysql.repository.ResolutionItemRepository;
import com.example.todoboardservice.web.model.ResolutionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResolutionItemService {

    @Autowired
    private ResolutionItemRepository resolutionItemRepository;

    public List<ResolutionItem> getTodoListById(Integer userId) {
        List<ResolutionItem> todoList  = new ArrayList<>();
        resolutionItemRepository.findByUserId(userId)
        .forEach (todoList::add);
        return todoList;
    }

    public List<ResolutionItem> getTodoList() {
        List<ResolutionItem> todoList  = new ArrayList<>();
        resolutionItemRepository.findAll()
                .forEach (todoList::add);
        return todoList;
    }

    public Optional<ResolutionItem> getResolutionItem(Integer itemId){
        return resolutionItemRepository.findById(itemId);
    }

    public void addResolutionItem(ResolutionItem resolutionItem) {
        resolutionItemRepository.save(resolutionItem);
    }

    public void updateResolutionItem(String userId, Integer itemId, ResolutionItem resolutionItem) {
        resolutionItemRepository.save(resolutionItem);
    }

   /* public void patchStatusToDone(String userId, Integer itemId, ResolutionItem resolutionItem) {
        for (int i = 0; i < toDoList.size(); i++){
            ResolutionItem r = toDoList.get(i);
            if(r.getItemId().equals(itemId) & r.getUserId().equals(userId)){
                r.setStatus("done");
            }
        }
    }*/

    public void deleteResolutionItem(Integer itemId) {
       resolutionItemRepository.deleteById(itemId);
    }
}