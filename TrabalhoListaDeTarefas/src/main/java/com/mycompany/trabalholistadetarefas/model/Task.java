/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalholistadetarefas.model;

import java.util.Date;

/**
 *
 * @author JOAOPEDROBACKXAVIER
 */
public class Task {
    
    int id;
    String title;
    String description;
    String expire_date;
    String state;

    public Task(String title, String description, String expire_date) {
        this.title = title;
        this.description = description;
        this.expire_date = expire_date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getExpire_date() {
        return expire_date;
    }

    public String getState() {
        return state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }

    public void setState(String status) {
        this.state = status;
    }
    
    
    
}
