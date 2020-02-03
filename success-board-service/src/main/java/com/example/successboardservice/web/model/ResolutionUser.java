package com.example.successboardservice.web.model;

public class ResolutionUser {

    private Integer resUserId;
    private String resUserName;

    public ResolutionUser(Integer resUserId, String resUserName) {
        this.resUserId = resUserId;
        this.resUserName = resUserName;
    }
    public ResolutionUser(){

    }

    public Integer getResUserId() {
        return resUserId;
    }

    public void setResUserId(Integer resUserId) {
        this.resUserId = resUserId;
    }

    public String getResUserName() {
        return resUserName;
    }

    public void setResUserName(String resUserName) {
        this.resUserName = resUserName;
    }
}
