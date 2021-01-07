package com.producedaily.productivityapp.task.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.producedaily.productivityapp.task.Task;

import java.security.Principal;

public interface TaskService {

    String findByUserName(Principal principal) throws JsonProcessingException;

    public void saveTask(Principal principal, Task theTask);

    public void deleteById(long id);

}
