package com.example.todoboardservice.web.rest;

import com.example.todoboardservice.service.ResolutionItemService;
import com.example.todoboardservice.web.model.ResolutionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todoresolutions")
public class TodoListController {

    @Autowired
    private ResolutionItemService resolutionItemService;

    @RequestMapping()
    public List<ResolutionItem> getTodoList() {
        return resolutionItemService.getTodoList();
    }

   @RequestMapping("/{userId}/{itemId}")
    public Optional<ResolutionItem> getResolutionItem(@PathVariable("itemId")String itemId){
        return resolutionItemService.getResolutionItem(itemId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{userId}")
    public void addResolutionItem(@RequestBody ResolutionItem resolutionItem){
        resolutionItemService.addResolutionItem(resolutionItem);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{userId}/{itemId}")
    public void updateResolutionItem(@RequestBody ResolutionItem resolutionItem, @PathVariable("itemId")String itemId, @PathVariable("userId") String userId){
        resolutionItemService.updateResolutionItem(userId, itemId, resolutionItem);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/{userId}/{itemId}")
    public void patchStatusToDone(@RequestBody ResolutionItem resolutionItem, @PathVariable("itemId")String itemId, @PathVariable("userId") String userId){
        resolutionItemService.patchStatusToDone(userId, itemId, resolutionItem);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{userId}/{itemId}")
    public void deleteResolutionItem(@PathVariable("userId") String userId, @PathVariable("itemId")String itemId){
        resolutionItemService.deleteResolutionItem(userId, itemId);
    }

}
