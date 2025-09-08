package com.example.event_registration_system.controller;

import com.example.event_registration_system.dto.event.ParticipantRequest;
import com.example.event_registration_system.entity.Participant;
import com.example.event_registration_system.repository.ParticipantRepository;
import com.example.event_registration_system.service.ParticipantService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ParticipantController {
    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService){
        this.participantService = participantService;
    }

    @PostMapping("/participants")
    public ResponseEntity<Participant> CreateParticipant(@Valid @RequestBody ParticipantRequest req){
        return participantService.CreateParticipant(req);
    }

    @DeleteMapping("/participants/{id}")
    public ResponseEntity<Participant> DeleteParticipant(@PathVariable Long id){
        return participantService.DeleteParticipantByID(id);
    }

    @GetMapping("/events/{eventID}/participants")
    public List<Participant> FindParticipantByEventID(@PathVariable("eventID") Long eventID){
        return participantService.FindParticipantByEventID(eventID);
    }

    @GetMapping("/stats/events")
    public int CountParticipantByEventID(){
        return participantService.CountParticipantByEventID();
    }



}
