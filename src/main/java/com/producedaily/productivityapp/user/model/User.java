package com.producedaily.productivityapp.user.model;

import javax.persistence.*;

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

    private String local_date;

    public User() {

    }

    public User(String username, String password, String email, String local_date) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.local_date = local_date;
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

    public String getLocal_date() {
        return local_date;
    }

    public void setLocal_date(String local_date) {
        this.local_date = local_date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", local_date='" + local_date + '\'' +
                '}';
    }
}
