package com.example.successboardservice.web.rest;

import com.example.successboardservice.service.DoneListService;
import com.example.successboardservice.web.model.ResolutionItem;
import com.example.successboardservice.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
/*@RequestMapping("/doneresolutions")*/
public class DoneListController {
    @Autowired
    private DoneListService doneListService;

    @RequestMapping("/resolutionsuser")
    public User getUsers() {
        return doneListService.getUsers();
    }

    /*@RequestMapping("/doneresolutions/{userId}")
    public List<ResolutionItem> getDoneList(@PathVariable("userId") String userId) {
        return doneListService.getDoneList(userId);
    }*/

    @RequestMapping(method = RequestMethod.PATCH, value = "/doneresolutions/{userId}/{itemId}")
    public void patchStatusToTodo(@RequestBody ResolutionItem resolutionItem, @PathVariable("itemId")String itemId, @PathVariable("userId") String userId){
        doneListService.patchStatusToTodo(userId, itemId, resolutionItem);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/doneresolutions/{userId}/{itemId}")
    public void deleteDoneResolutionItem(@PathVariable("userId") String userId, @PathVariable("itemId")String itemId){
        doneListService.deleteDoneResolutionItem(userId, itemId);
    }


}
