package com.example.event_registration_system.entity;

import jakarta.validation.constraints.NotNull;

@NotNull
public class Event {
    private String name;
    private String title;

    private String location;

//    private String createdAt;
//    private String updatedAt;
//    private String deletedAt;

    private String description;

    private Long id;
    private int capacity;

    public Event(Long id, String name, String title, String description, String location,
                 int capacity){
        this.id = id; this.name = name; this.title = title; this.description = description;
        this.location = location; this.capacity = capacity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }
}
