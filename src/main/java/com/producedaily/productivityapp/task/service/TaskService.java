package com.producedaily.productivityapp.task.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.producedaily.productivityapp.task.Task;

import java.security.Principal;
import java.util.List;

public interface TaskService {

    // finished and unfinished tasks for day
    List<Task> findAllDailyTasksByUsername(Principal principal);

    List<Task> findUnfinishedTasksByUserName(Principal principal);

    Task findCurrentTaskByUserName(Principal principal);

    Task findTaskById(long taskId);

    void saveNewTask(Principal principal, Task task);

    void updateTaskToFinished(Principal principal, Task task);

    void setInitialCurrentTask(List<Task> tasks);

    void setCurrentTaskById(Principal principal, long taskId);

}
