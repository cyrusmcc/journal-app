package com.producedaily.productivityapp.journal;

import javax.persistence.*;

@Entity
public class JournalEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entry_id")
    private long id;

    private String entryDate;

    private String text;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "journal_id")
    private Journal journal;

    public JournalEntry() {
    }

    public JournalEntry(String entryDate) {
        this.entryDate = entryDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    @Override
    public String toString() {
        return "JournalEntry{" +
                "id=" + id +
                ", entryDate='" + entryDate + '\'' +
                ", text='" + text + '\'' +
                ", journal=" + journal +
                '}';
    }
}
