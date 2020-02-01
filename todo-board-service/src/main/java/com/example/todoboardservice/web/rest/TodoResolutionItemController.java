package com.example.todoboardservice.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resolutionsitem")
public class TodoResolutionItemController {

   /* public Item getListItem(@PathVariable("listId") String listId) {
        return new Item(listId, "Kekse backen");
    }

    @RequestMapping("/user/{userId}")
    public ItemList getItemList(@PathVariable("userId") String userId){
        List<Item> itemsL = Arrays.asList(
                new Item("2", "Aufräumen"),
                new Item("1", "Kekse backen"),
                new Item("1", "VS"),
                new Item("1", "Lernen")
        );

        ItemList items = new ItemList();
        items.setItems(itemsL);
        return items;
    }*/
}
