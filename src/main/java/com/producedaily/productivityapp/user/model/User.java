package com.producedaily.productivityapp.user.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.producedaily.productivityapp.event.model.Event;
import com.producedaily.productivityapp.goal.model.Goal;
import com.producedaily.productivityapp.goal.model.GoalOccurence;
import com.producedaily.productivityapp.goal.model.GoalPeriod;
import com.producedaily.productivityapp.goal.service.GoalService;
import com.producedaily.productivityapp.journal.model.Journal;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id")
    private long id;

    private String username;

    private String password;

    private String email;

    private String role;

    private String localDate;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    @JsonManagedReference
    private List<Event> events;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    @JsonManagedReference
    private List<Goal> goals;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "journal_id")
    private Journal journal;

    public User() {

    }

    public User(String username, String password, String email, String localDate, Journal journal) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.localDate = localDate;
        this.journal = journal;
        this.journal.setUser(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public List<Event> sortEventsByDate(List<Event> theEvents) {

        Event[] events = new Event[theEvents.size()];
        Event tempEvent;

        for(int i = 0; i < theEvents.size(); i++) {
            events[i] = theEvents.get(i);
        }

        for(int i = 0; i < events.length - 1; i++) {
            for(int j = 1; j < events.length - i; j++) {

                LocalDate date1 = LocalDate.parse(events[j - 1].getEventDate());

                LocalDate date2 = LocalDate.parse(events[j].getEventDate());

                if(date1.isAfter(date2)) {

                    tempEvent = events[j - 1];

                    events[j - 1] = events[j];

                    events[j] = tempEvent;
                }
            }
        }

        List<Event> sortedEventList = Arrays.asList(events);

        return sortedEventList;
    }

    // goals that are older than current date are considered finished
    public void deletePastGoals(List<Goal> goals) {

        LocalDate currentDate = LocalDate.parse(getLocalDate());

        List<Goal> pastGoals = goals;

        for(int i = 0; i < goals.size(); i++) {

            Goal currentGoal = goals.get(i);

            GoalPeriod currentGoalPeriod = currentGoal.getGoalPeriod();

            GoalOccurence currentGoalOccurence = currentGoal.getGoalOccurrence();

            LocalDate currentGoalDate = LocalDate.parse(currentGoal.getGoalDate());

            if((currentGoalPeriod == GoalPeriod.DAILY) && (currentDate.isAfter(currentGoalDate))
                    && (currentGoalOccurence != GoalOccurence.REOCCUR)) {

                currentGoal.setFinished(true);

                currentGoal.setNote(currentGoal.getName() + "didn't get completed.");

                pastGoals.add(currentGoal);

            }

            // weekly if date is past 7 days and not reoccur

        }
    }

    public List<Goal> getFinishedGoals(List<Goal> goals) {

        List<Goal> unfinishedGoals = new ArrayList<>();

        for(int i = 0; i < goals.size(); i++) {

            if((goals.get(i).isFinished() == false) && (goals.get(i) != null)) {

                Goal finished = goals.get(i);

                unfinishedGoals.add(goals.get(i));
            }
        }
        return unfinishedGoals;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", goals=" + goals +
                '}';
    }
}
