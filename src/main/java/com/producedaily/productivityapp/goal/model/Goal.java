package com.producedaily.productivityapp.goal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.producedaily.productivityapp.user.model.User;

import javax.persistence.*;

@Entity
@Table(name="goal")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id")
    private long id;

    private String name;

    @Column(length = 500)
    private String note;

    private boolean isFinished;

    private boolean isCurrentGoal;

    private String goalDate;

    private GoalPeriod goalPeriod;

    private GoalOccurence goalOccurrence;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public Goal() {
    }

    public Goal(String name, boolean isFinished) {
        this.name = name;
        this.isFinished = isFinished;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGoalDate() {
        return goalDate;
    }

    public void setGoalDate(String goalDate) {
        this.goalDate = goalDate;
    }

    public GoalPeriod getGoalPeriod() {
        return goalPeriod;
    }

    public void setGoalPeriod(GoalPeriod goalPeriod) {
        this.goalPeriod = goalPeriod;
    }

    public GoalOccurence getGoalOccurrence() {
        return goalOccurrence;
    }

    public void setGoalOccurrence(GoalOccurence goalOccurrence) {
        this.goalOccurrence = goalOccurrence;
    }

    public boolean getCurrentGoalStatus() {
        return isCurrentGoal;
    }

    public boolean isCurrentGoal(boolean b) {
        return isCurrentGoal;
    }

    public void setCurrentGoal(boolean currentGoal) {
        isCurrentGoal = currentGoal;
    }

}

