package com.producedaily.productivityapp.dashboard.controller;

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

        model.addAttribute("userTasks",
                taskService.findTasksByUserName(principal));

        model.addAttribute("currentTask",
                taskService.findCurrentTaskByUserName(principal));

        model.addAttribute("journalEntry",
                journalService.findEntryByDate(principal));

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
    public String updateTask(Principal principal, @ModelAttribute("theTask") Task theTask) {

        theTask.setCurrentTask(false);
        taskService.updateTask(principal, theTask);

        return "redirect:/home";

    }
}
