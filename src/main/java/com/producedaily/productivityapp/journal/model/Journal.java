package com.producedaily.productivityapp.journal.model;

import com.producedaily.productivityapp.user.model.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "journal_id")
    private long id;

    @OneToOne(mappedBy = "journal")
    private User user;

    @OneToMany(mappedBy = "journal", cascade = {CascadeType.ALL})
    private List<JournalEntry> entries;

    public Journal() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<JournalEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<JournalEntry> entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}
