package com.producedaily.productivityapp.user.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.producedaily.productivityapp.event.model.Event;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;

    private String username;

    private String password;

    private String email;

    private String role;

    private String localDate;

    @OneToMany(mappedBy = "user", cascade = {
            CascadeType.ALL
    })
    @JsonManagedReference
    private List<Event> events;

    public User() {

    }

    public User(String username, String password, String email, String localDate) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.localDate = localDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String local_date) {
        this.localDate = local_date;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }


    public List<Event> sortEventsByDate(List<Event> theEvents) {

        Event[] events = new Event[theEvents.size()];
        Event tempEvent;

        for(int i = 0; i < theEvents.size(); i++) {
            events[i] = theEvents.get(i);
            System.out.println(events[i].toString());
        }

        System.out.println("Before: " +
                events[0].getEventDate() + "\n" +
                events[1].getEventDate() + "\n" +
                events[2].getEventDate() + "\n" +
                events[3].getEventDate() + "\n");

        for(int i = 0; i < events.length - 1; i++) {
            for(int j = 1; j < events.length - i; j++) {

                LocalDate date1 = LocalDate.parse(events[j - 1].getEventDate());
                System.out.println(date1);

                LocalDate date2 = LocalDate.parse(events[j].getEventDate());
                System.out.println(date2);

                if(date1.isAfter(date2)) {

                    tempEvent = events[j - 1];

                    events[j - 1] = events[j];

                    events[j] = tempEvent;
                }
            }
        }

        System.out.println("");

        System.out.println( "After: " +
                events[0].getEventDate() + "\n" +
                events[1].getEventDate() + "\n" +
                events[2].getEventDate() + "\n" +
                events[3].getEventDate());
        List<Event> sortedEventList = Arrays.asList(events);

        return sortedEventList;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", local_date='" + localDate + '\'' +
                '}';
    }
}
