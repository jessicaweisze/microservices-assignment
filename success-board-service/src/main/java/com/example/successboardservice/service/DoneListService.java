package com.example.successboardservice.service;

import com.example.successboardservice.web.model.ResolutionItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoneListService {
    private List<ResolutionItem> doneList= new ArrayList<>(Arrays.asList(
            new ResolutionItem("1", "Mehr Sachen selber nähen", "mind. 3 Kleider, 2 Tshirts und eine Tasche", "done", "01"),
            new ResolutionItem("2", "Mehr lesen", "mind. 5 Bücker lesen", "done", "02"),
            new ResolutionItem("3", "Mehr Sport machen", "mind. 2 mal pro Woche Sport machen", "todo", "01"),
            new ResolutionItem("4", "Mehr Vielfalt beim Keksebacken", "Auch mal Alpakakekse backen", "todo", "02")
    ));

    public List<ResolutionItem> getDoneList(String userId) {
        return doneList.stream().filter(r -> r.getUserId().equals(userId) & r.getStatus().equals("done")).collect(Collectors.toList());
    }

    /*Brauchen wir das?*/
    public ResolutionItem getDoneResolutionItem(String userId, String itemId){
        return doneList.stream().filter(r ->
                r.getUserId().equals(userId) & r.getItemId().equals(itemId)).findFirst().get();
    }

    public void patchStatusToTodo(String userId, String itemId, ResolutionItem resolutionItem) {
        for (int i = 0; i < doneList.size(); i++){
            ResolutionItem r = doneList.get(i);
            if(r.getItemId().equals(itemId) & r.getUserId().equals(userId)){
                r.setStatus("todo");
            }
        }
    }

    public void deleteDoneResolutionItem(String userId, String itemId) {
        doneList.removeIf(r ->
                r.getUserId().equals(userId) & r.getItemId().equals(itemId));
    }
}
