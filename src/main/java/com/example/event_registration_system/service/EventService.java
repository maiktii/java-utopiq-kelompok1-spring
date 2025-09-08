package com.example.event_registration_system.service;

import com.example.event_registration_system.dto.event.EventRequest;
import com.example.event_registration_system.entity.Event;
import com.example.event_registration_system.repository.EventRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository repo;

    public EventService(EventRepository repo) {
        this.repo = repo;
    }

    public List<Event> listEvent() {
        return repo.findAll();
    }

    public ResponseEntity<Event> CreateEvent(EventRequest req) {
        Event events = repo.save(new Event(null, req.getName(), req.getTitle(), req.getDescription(), req.getLocation(), req.getCapacity()));
        return ResponseEntity.status(HttpStatus.CREATED).body(events);
    }

    public ResponseEntity<Event> ListEventById(Long id) {
        return repo.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Event> ReplaceEventById(Long id, Event req) {
        if (!repo.exists(id)) return ResponseEntity.notFound().build();
        req.setId(id);
        return ResponseEntity.ok(repo.save(req));
    }

    public ResponseEntity<Event> DeleteEventByID(Long id){
        if (!repo.exists(id)) return ResponseEntity.notFound().build();
        repo.delete(id);
        return ResponseEntity.noContent().build();
    }
}
