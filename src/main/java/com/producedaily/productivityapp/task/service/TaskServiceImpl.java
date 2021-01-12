package com.producedaily.productivityapp.task.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.producedaily.productivityapp.journal.model.Journal;
import com.producedaily.productivityapp.journal.model.JournalEntry;
import com.producedaily.productivityapp.journal.service.JournalService;
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

    @Autowired
    JournalService journalService;

    @Override
    public List<Task> findTasksByUserName(Principal principal) {

        User user = userService.findByUsername(principal.getName());

        List<Task> userTasks = user.getTasks();

        user.isTaskFinished(userTasks);

        return userTasks;
    }

    @Override
    public Task findCurrentTaskByUserName(Principal principal) {

        List<Task> tasks =  findTasksByUserName(principal);

        Task currentTask = null;

        for(int i = 0; i < tasks.size(); i++) {

            if(tasks.get(i).isFinished() == false) {
                tasks.get(i).setCurrentTask(true);

                System.out.println("inside if and " + tasks.get(i).isCurrentTask());

                currentTask = tasks.get(i);

                taskRepository.save(currentTask);
                break;
            }
        }
        return currentTask;
    }

    @Override
    public void saveNewTask(Principal principal, Task task) {

        User user = userService.findByUsername(principal.getName());

        task.setUser(user);

        task.setFinished(false);

        task.setTaskDate(user.getLocalDate());

        taskRepository.save(task);
    }

    @Override
    public void updateTask(Principal principal, Task task) {

        journalService.findJournal(principal);

        // add task note to journal before deletion
        if(task.getNote() != null) {

            JournalEntry entry = journalService.findEntryByJournalAndDate(
                    journalService.findJournal(principal), task.getTaskDate());

            if(entry.getTaskSummary() != null ) {

                String taskSummary = entry.getTaskSummary() + " ### " + task.getName() + ": " + task.getNote();

                entry.setTaskSummary(taskSummary);

                journalService.saveEntry(entry);
            }

            if(entry.getTaskSummary() == null) {

                String taskSummary = "### " + task.getName() + ": " + task.getNote();

                entry.setTaskSummary(taskSummary);

                journalService.saveEntry(entry);

            }
        }

        task.setFinished(true);

        taskRepository.save(task);
    }
}
