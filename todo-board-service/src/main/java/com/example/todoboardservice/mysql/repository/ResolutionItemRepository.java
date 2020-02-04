package com.example.todoboardservice.mysql.repository;

import com.example.todoboardservice.web.model.ResolutionItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ResolutionItemRepository extends CrudRepository <ResolutionItem, Integer> {

    public List<ResolutionItem> findByUserId(Integer userId);

}
