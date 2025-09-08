package com.example.event_registration_system.repository;

import com.example.event_registration_system.entity.Event;
import com.example.event_registration_system.entity.Participant;
import jakarta.servlet.http.Part;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ParticipantRepository {
    private final Map<Long, Participant> data = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(0);

    public ParticipantRepository(){
        save(new Participant(null, 1L, "test1", "test1@gmail.com", "1234567"));
        save(new Participant(null, 1L, "test2", "test2@gmail.com", "1234568"));
    }


    public Participant save(Participant p) {
        if (p.getId() == null) p.setId(seq.incrementAndGet());
        data.put(p.getId(), p);
        return p;
    }

    public List<Participant> findAllParticipant(){
       return new ArrayList<Participant>(data.values());
    }

    public Optional<Participant> findByEventId(Long eventID) { return Optional.ofNullable(data.get(eventID)); }

    public void delete(Long id) { data.remove(id); }
    public boolean exists(Long id) { return data.containsKey(id); }
}
