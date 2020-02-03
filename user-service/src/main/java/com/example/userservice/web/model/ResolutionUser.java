package com.example.userservice.web.model;

import javax.persistence.*;

@Entity
@Table(name="res_user_table")
public class ResolutionUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="res_user_id")
    private Integer resUserId;
    @Column(name="res_user_name")
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
