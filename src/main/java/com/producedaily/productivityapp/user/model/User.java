package com.producedaily.productivityapp.user.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.producedaily.productivityapp.event.model.Event;

import javax.persistence.*;
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
