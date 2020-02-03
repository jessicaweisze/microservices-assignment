package com.example.userservice.web.model;

import javax.persistence.*;

@Entity
@Table()
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="name-id")
    private Integer nameId;
    @Column(name="user-name")
    private String name;

    public User(Integer nameId, String name) {
        this.nameId = nameId;
        this.name = name;
    }
    public User(){

    }

    public Integer getNameId() {
        return nameId;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
