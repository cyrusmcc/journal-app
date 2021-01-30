package com.producedaily.productivityapp.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.producedaily.productivityapp.event.model.Event;
import com.producedaily.productivityapp.event.service.EventService;
import com.producedaily.productivityapp.journal.model.JournalEntry;
import com.producedaily.productivityapp.journal.service.JournalService;
import com.producedaily.productivityapp.task.Task;
import com.producedaily.productivityapp.task.service.TaskService;
import com.producedaily.productivityapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;

    @Autowired
    JournalService journalService;
    
    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public Model getActiveUserData(Principal principal, Model model) throws JsonProcessingException {

        model.addAttribute("username", principal.getName());

        model.addAttribute("userLocalDate",
                userService.findLocalDate(principal));

        model.addAttribute("month",
                userService.findMonth(principal));

        model.addAttribute("dayOfMonth",
                userService.findDayOfMonth(principal));

        model.addAttribute("daysInMonth",
                userService.findDaysInMonth(principal));

        model.addAttribute("userEvents",
                eventService.findByUserName(principal));

        model.addAttribute("unfinishedDailyUserTasks",
                taskService.findUnfinishedTasksByUserName(principal));

        model.addAttribute("allDailyUserTasks",
                taskService.findAllDailyTasksByUsername(principal));

        model.addAttribute("currentTask",
                taskService.findCurrentTaskByUserName(principal));

        model.addAttribute("journalEntry",
                journalService.findEntryByDate(principal));

        model.addAttribute("theNewCurrentTask",
                new Task());

        return model;
    }

    @GetMapping("/newEvent")
    public String showEventAddForm(Model model) {

        Event event = new Event();

        model.addAttribute("event", event);

        return "/event-form";
    }

    @PostMapping("/saveEvent")
    public String saveEvent(Principal principal, @ModelAttribute("event") Event event) {

        eventService.saveEvent(principal, event);

        return "redirect:/home";
    }

    @GetMapping("/newTask")
    public String showTaskAddForm(Model model) {

        Task task = new Task();

        model.addAttribute("task", task);

        return "/task-form.html";
    }

    @PostMapping("/saveTask")
    public String saveTask(Principal principal, @ModelAttribute("task") Task task) {

        taskService.saveNewTask(principal, task);

        return "redirect:/home";
    }

    @PostMapping("/saveEntry")
    public String saveJournalEntry(@ModelAttribute("entry") JournalEntry entry) {

        journalService.saveEntry(entry);

        return "redirect:/home";
    }

    @PostMapping("/updateTask")
    public String updateTaskToFinished(Principal principal, @ModelAttribute("theTask") Task theTask) {

        theTask.setCurrentTask(false);
        taskService.updateTaskToFinished(principal, theTask);

        return "redirect:/home";

    }

    @PostMapping("/updateCurrentTask")
    public String updateCurrentTask(Principal principal,Task task) {

        // task equals 0 when current task is submitted to update current task
        if(task.getCurrentTaskStatus() == false && (task.getId() != 0)) {

            taskService.setCurrentTaskById(principal, task.getId());

        }

        return "redirect:/home";

    }

}
