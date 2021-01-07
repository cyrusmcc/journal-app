package com.producedaily.productivityapp.task.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.producedaily.productivityapp.task.Task;
import com.producedaily.productivityapp.task.repository.TaskRepository;
import com.producedaily.productivityapp.user.model.User;
import com.producedaily.productivityapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    @Override
    public String findByUserName(Principal principal) throws JsonProcessingException {

        User user = userService.findByUsername(principal.getName());

        String json = new ObjectMapper().writeValueAsString(user.getTasks());

        return json;
    }

    @Override
    public void saveTask(Principal principal, Task theTask) {

        User user = userService.findByUsername(principal.getName());

        theTask.setUser(user);

        theTask.setFinished(false);

        taskRepository.save(theTask);
    }

    @Override
    public void deleteById(long event_id) {
        taskRepository.deleteById(event_id);
    }

    public boolean isExistByUserId(long id) {
        return taskRepository.existsById(id);
    }
}
