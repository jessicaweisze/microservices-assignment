package com.example.todoboardservice.mysql.repository;

import com.example.todoboardservice.web.model.ResolutionItem;
import org.springframework.data.repository.CrudRepository;

public interface ResolutionItemRepository extends CrudRepository <ResolutionItem, String> {


}
