package com.example.event_registration_system.repository;

import com.example.event_registration_system.entity.Event;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EventRepository {
    private final Map<Long, Event> data = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(0);

    public EventRepository(){
        save(new Event(null, "Event 1", "Event Title 1", "Event Description 1", "Event Location 1", 100));
        save(new Event(null, "Event 2", "Event Title 2", "Event Description 2", "Event Location 2", 200));
    }

    public Event save(Event ev) {
        if (ev.getId() == null) ev.setId(seq.incrementAndGet());
        data.put(ev.getId(), ev);
        return ev;
    }

    public List<Event> findAll(){
        return new ArrayList<Event>(data.values());
    }

    public Optional<Event> findById(Long id){
        return Optional.ofNullable(data.get(id));
    }
}
