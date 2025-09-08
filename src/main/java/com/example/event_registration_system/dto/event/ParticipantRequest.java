package com.example.event_registration_system.dto.event;

public class ParticipantRequest {
    private Long id;
    private Long eventID;

    private String name;
    private String email;
    private String phone;

    public ParticipantRequest(Long id, Long eventID, String name, String email, String phone){
        this.id = id; this.eventID = eventID;
        this.name = name; this.email = email; this.phone = phone;
    }

    public void setEventID(Long eventID) {
        this.eventID = eventID;
    }

    public Long getEventID() {
        return eventID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
