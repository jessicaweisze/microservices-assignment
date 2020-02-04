package com.example.successboardservice.web.model;

public class ResolutionItem {
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
