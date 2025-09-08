package com.example.event_registration_system.controller;

import com.example.event_registration_system.entity.Event;
import com.example.event_registration_system.repository.EventRepository;
import com.example.event_registration_system.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }


    @GetMapping
    public List<Event> findAllEvent(){
        return eventService.list();
    }

}
