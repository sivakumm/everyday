package com.zuehlke.hatch.backend.model;

import java.util.Date;


public class Todo {

    private String id;


    private String description;

    private String title;

    private Boolean completed;

    private Date createdAt;

    public Todo(String id, String description, String title, Boolean completed, Date createdAt) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.completed = completed;
        this.createdAt = createdAt;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


}
