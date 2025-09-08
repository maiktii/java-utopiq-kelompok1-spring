package com.example.event_registration_system.dto.event;

import jakarta.validation.constraints.NotBlank;

public class EventRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String title;

    private String description;
    private String location;
    private int capacity;

//    private String createdAt;
//    private String updatedAt;
//    private String deletedAt;

    public EventRequest(String name, String title, String description, String location, int capacity){
        this.name = name; this.title = title; this.description = description;
        this.location = location; this.capacity = capacity;
    };

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
