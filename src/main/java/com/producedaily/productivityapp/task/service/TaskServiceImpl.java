package com.producedaily.productivityapp.task.service;

import com.producedaily.productivityapp.journal.model.JournalEntry;
import com.producedaily.productivityapp.journal.service.JournalService;
import com.producedaily.productivityapp.task.Task;
import com.producedaily.productivityapp.task.repository.TaskRepository;
import com.producedaily.productivityapp.user.model.User;
import com.producedaily.productivityapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
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
    public List<Task> findAllDailyTasksByUsername(Principal principal) {

        User user = userService.findByUsername(principal.getName());

        List<Task> allUserTasks = user.getTasks();

        List<Task> currentDateTasks = new ArrayList<>();

        for(int i = 0; i < allUserTasks.size(); i++) {

            String taskDate = allUserTasks.get(i).getTaskDate();

            String userDate = userService.findLocalDate(principal);

            if(taskDate.equals(userDate)) {

                currentDateTasks.add(allUserTasks.get(i));

            }
        }
        return currentDateTasks;
    }

    @Override
    public List<Task> findUnfinishedTasksByUserName(Principal principal) {

        User user = userService.findByUsername(principal.getName());

        List<Task> userTasks = user.getTasks();

        List<Task> unfinishedTasks = user.getFinishedTasks(userTasks);

        System.out.println(unfinishedTasks);

        return unfinishedTasks;
    }

    @Override
    public Task findCurrentTaskByUserName(Principal principal) {

        List<Task> tasks =  findUnfinishedTasksByUserName(principal);

        Task currentTask = null;

        for(int i = 0; i < tasks.size(); i++) {

            if(tasks.get(i).isCurrentTask(true) == true) {
                currentTask = tasks.get(i);
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

        setInitialCurrentTask(user.getTasks());
    }

    // first unfinished task set to current until user specifies new current task
    public void setInitialCurrentTask(List<Task> tasks) {

        List<Task> unfinshedTasks = new ArrayList<>();
        boolean currentTaskExists = false;

        for(int i = 0; i < tasks.size(); i++) {

            if(tasks.get(i).isFinished() == false) {

                Task unfinishedTask = tasks.get(i);

                unfinshedTasks.add(unfinishedTask);
            }

            currentTaskExists = unfinshedTasks.stream().anyMatch(
                    task -> task.isCurrentTask(true));

        }

        System.out.println("THERE IS CURRENT TASK = " + currentTaskExists);

        if(currentTaskExists == false) {

            Task newCurrentTask = unfinshedTasks.get(0);

            newCurrentTask.setCurrentTask(true);

            taskRepository.save(newCurrentTask);
        }
    }

    @Override
    public void setCurrentTaskById(Principal principal, long taskId) {

        Task task = taskRepository.findTaskById(taskId);

        List<Task> userTasks = userService.findTasks(principal);

        for(int i = 0; i < userTasks.size(); i++) {
            userTasks.get(i).setCurrentTask(false);
        }

        task.setCurrentTask(true);
        taskRepository.save(task);
    }

    @Override
    public void updateTaskToFinished(Principal principal, Task task) {

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

        setInitialCurrentTask(userService.findTasks(principal));
    }
}