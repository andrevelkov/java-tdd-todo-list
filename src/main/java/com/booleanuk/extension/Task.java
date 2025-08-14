package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.util.Date;

public class Task {
    private int id;
    private String name;
    private Date creationTime;
    private Boolean status;

    public Task(int id, String name, Boolean status) {
        this.id = id;
        this.name = name;
        this.creationTime = getRandomDate();
        this.status = status;
    }

    public Date getRandomDate() {
        long currentTime = System.currentTimeMillis();
        // Define time range: last year (365 days)
        long yearInMillis = 365L * 24 * 60 * 60 * 1000;
        long randomTime = currentTime - (long)(Math.random() * yearInMillis);
        return new Date(randomTime);
    }

    public Task() {

    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void toggleStatus() {
        this.status = !status;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

//
//I want to be able to get a task by a unique ID.
//I want to update the name of a task by providing its ID and a new name.
//I want to be able to change the status of a task by providing its ID.
//I want to be able to see the date and time that I created each task.