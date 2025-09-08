package com.example.event_registration_system.controller;

import com.example.event_registration_system.dto.event.EventRequest;
import com.example.event_registration_system.entity.Event;
import com.example.event_registration_system.repository.EventRepository;
import com.example.event_registration_system.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping("/event")
    public List<Event> findAllEvent(){
        return eventService.listEvent();
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<Event> FindEventByID(@PathVariable Long id){
        return eventService.ListEventById(id);
    }

    @PostMapping("/events")
    public ResponseEntity<Event> CreateEvent(@Valid @RequestBody EventRequest req){
        return eventService.CreateEvent(req);
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<Event> ReplaceAllEvent(@PathVariable Long id, @Valid @RequestBody Event req){
        return eventService.ReplaceEventById(id, req);
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<Event> DeleteEventByID(@PathVariable Long id){
        return eventService.DeleteEventByID(id);
    }



}
