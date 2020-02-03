package com.example.successboardservice.web.model;

public class UserResolutionItem {
    private String title;
    private String description;
    private String status;
    private String userName;

    public UserResolutionItem(String title, String description, String status, String userName) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.userName = userName;
    }
    UserResolutionItem(){

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
