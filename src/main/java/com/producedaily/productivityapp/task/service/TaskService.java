package com.producedaily.productivityapp.task.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.producedaily.productivityapp.task.Task;

import java.security.Principal;
import java.util.List;

public interface TaskService {

    List<Task> findTasksByUserName(Principal principal);

    Task findCurrentTaskByUserName(Principal principal);

    void saveNewTask(Principal principal, Task task);

    void updateTask(Principal principal, Task task);

}
