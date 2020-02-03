package com.example.todoboardservice.web.model;


import sun.awt.image.IntegerComponentRaster;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ResolutionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;
    private String title;
    private String description;
    private String status;
    private Integer userId;

    public ResolutionItem(Integer itemId, String title, String description, String status, Integer userId) {
        this.itemId = itemId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.userId = userId;
    }

    public ResolutionItem(){

    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

