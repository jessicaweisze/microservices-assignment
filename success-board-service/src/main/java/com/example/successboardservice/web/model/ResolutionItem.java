package com.example.successboardservice.web.model;

public class ResolutionItem {
    private String itemId;
    private String title;
    private String description;
    private String status;
    private String userId;

    public ResolutionItem(String itemId, String title, String description, String status) {
        this.itemId = itemId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.userId = userId;
    }

    public ResolutionItem(String s, String mehr_sachen_selber_nähen, String s1, String todo, String s2){

    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
