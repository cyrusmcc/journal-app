package com.producedaily.productivityapp.task.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.producedaily.productivityapp.task.Task;

import java.security.Principal;

public interface TaskService {

    String findByUserName(Principal principal) throws JsonProcessingException;

    void saveTask(Principal principal, Task task);

    void deleteById(long id);
}
