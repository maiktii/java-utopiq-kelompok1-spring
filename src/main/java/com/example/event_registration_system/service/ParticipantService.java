package com.example.event_registration_system.service;

import com.example.event_registration_system.dto.event.ParticipantRequest;
import com.example.event_registration_system.entity.Event;
import com.example.event_registration_system.entity.Participant;
import com.example.event_registration_system.repository.EventRepository;
import com.example.event_registration_system.repository.ParticipantRepository;
import jakarta.servlet.http.Part;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {
    private final ParticipantRepository parRepo;
    private final EventRepository evRepo;

    public ParticipantService(ParticipantRepository parRepo, EventRepository evRepo) {
        this.parRepo = parRepo;
        this.evRepo = evRepo;
    }

    public ResponseEntity<Participant> CreateParticipant(ParticipantRequest req) {
        if (!evRepo.exists(req.getEventID())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Participant participants = parRepo.save(new Participant(null, req.getEventID(), req.getName(), req.getEmail(), req.getPhone()));
        return ResponseEntity.status(HttpStatus.CREATED).body(participants);
    }

    public ResponseEntity<Participant> DeleteParticipantByID(Long id) {
        if (!evRepo.exists(id)) return ResponseEntity.notFound().build();
        parRepo.delete(id);
        return ResponseEntity.noContent().build();
    }

    public List<Participant> FindParticipantByEventID(Long eventID) {
        if (eventID == 0) return Collections.emptyList();

        Optional<Long> eventDataID = evRepo.findById(eventID).map(Event::getId);

        if (eventDataID.isPresent()) {
            Long foundEventID = eventDataID.get();

            List<Participant> data = parRepo.findAllParticipant();

            for (Participant participant : data) {
                if (foundEventID.equals(participant.getEventID())) {
                     return parRepo.findAllParticipant();
                }
            }
        }

        return Collections.emptyList();
    }



    public int CountParticipantByEventID(){
        int count = 0;

        List<Event> dataEvent = evRepo.findAll();

        for (Event event : dataEvent) {
            Optional<Long> eventDataID = evRepo.findById(event.getId()).map(Event::getId);

            if (eventDataID.isPresent()) {
                Long foundEventID = eventDataID.get();

                List<Participant> data = parRepo.findAllParticipant();

                for (Participant participant : data) {
                    if (foundEventID.equals(participant.getEventID())) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

}
