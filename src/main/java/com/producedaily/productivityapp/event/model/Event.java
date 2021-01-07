package com.producedaily.productivityapp.event.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.producedaily.productivityapp.user.model.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

enum EventStatus {
    PASSED,
    ACTIVE,
    FUTURE
}

@Entity
@Table(name="event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "event_id")
    private long id;

    private String name;

    private String description;

    private String eventDate;

    private EventStatus eventStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public Event() {
    }

    public Event(int event_id, String name, String description, String eventDate) {
        this.id = event_id;
        this.name = name;
        this.description = description;
        this.eventDate = eventDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long event_id) {
        this.id = event_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EventStatus getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventDate) {

        LocalDate date = LocalDate.parse(eventDate);

        if(date == null) {
            throw new NullPointerException();
        }
        else if(date.isBefore(LocalDate.now())) {
            eventStatus = EventStatus.PASSED;
        }
        else if(date.isEqual(LocalDate.now())) {
            eventStatus = EventStatus.ACTIVE;
        }
        else if(date.isAfter(LocalDate.now())) {
            eventStatus = EventStatus.FUTURE;
        }
    }
}
