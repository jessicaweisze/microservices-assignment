package com.example.todoboardservice.service;

import com.example.todoboardservice.web.model.ResolutionItem;

import java.util.List;
import java.util.Optional;

public interface ResolutionItemServiceInterface {

    public List<ResolutionItem> getTodoListById(Integer userId);

    public List<ResolutionItem> getTodoList();

    public Optional<ResolutionItem> getResolutionItem(Integer itemId);

    public void addResolutionItem(ResolutionItem resolutionItem);

    public void updateResolutionItem(String userId, Integer itemId, ResolutionItem resolutionItem);

    public void deleteResolutionItem(Integer itemId);
}
