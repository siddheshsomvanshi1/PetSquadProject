package com.example.petsquad;

public class EventModal {

    private String eventName;
    private  String eventDate;
    private String eventVenue;
    private String eventTime;
    private int id;


    public EventModal(String eventName, String eventDate, String eventVenue, String eventTime) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventVenue = eventVenue;
        this.eventTime = eventTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
