package com.example.event_registration_system.service;

import com.example.event_registration_system.entity.Event;
import com.example.event_registration_system.repository.EventRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class EventService {
    private final EventRepository repo;

    public EventService(EventRepository repo){
        this.repo = repo;
    }

    public List<Event> list(){
        return repo.findAll();
    }
}
