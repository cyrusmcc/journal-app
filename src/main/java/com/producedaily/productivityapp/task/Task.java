package com.producedaily.productivityapp.task;


import com.producedaily.productivityapp.user.model.User;

import javax.persistence.*;

enum TaskStatus {

        }


//@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private long id;

    private String name;

    private String note;

    private boolean isFinished;

    private TaskStatus taskStatus;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "user_id")
    private User user;


    public Task() {
    }

    public Task(String name, boolean isFinished, TaskStatus taskStatus, User user) {
        this.name = name;
        this.isFinished = isFinished;
        this.taskStatus = taskStatus;
        this.user = user;
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

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taskStatus=" + taskStatus +
                ", user=" + user +
                '}';
    }
}
