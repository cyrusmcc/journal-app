package com.producedaily.productivityapp.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.producedaily.productivityapp.event.model.Event;
import com.producedaily.productivityapp.event.service.EventService;
import com.producedaily.productivityapp.journal.model.JournalEntry;
import com.producedaily.productivityapp.journal.service.JournalService;
import com.producedaily.productivityapp.goal.model.Goal;
import com.producedaily.productivityapp.goal.service.GoalService;
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
    private GoalService goalService;

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

        model.addAttribute("unfinishedDailyUserGoals",
                goalService.findUnfinishedGoalsByUserName(principal));

        model.addAttribute("allDailyUserGoals",
                goalService.findAllDailyGoalsByUsername(principal));

        model.addAttribute("journalEntry",
                journalService.findEntryByDate(principal));

        model.addAttribute("event", new Event());

        model.addAttribute("goal", new Goal());


        return model;
    }

    @PostMapping("/saveEvent")
    public String saveEvent(Principal principal, @ModelAttribute("event") Event event) {

        eventService.saveEvent(principal, event);

        return "redirect:/home";
    }

    @PostMapping("/saveGoal")
    public String saveGoal(Principal principal, @ModelAttribute("goal") Goal goal) {

        goalService.saveNewGoal(principal, goal);

        return "redirect:/home";
    }

    @PostMapping("/saveEntry")
    public String saveJournalEntry(@ModelAttribute("entry") JournalEntry entry) {

        journalService.saveEntry(entry);

        return "redirect:/home";
    }

    @PostMapping("/updateGoal")
    public String updateGoalToFinished(Principal principal, @ModelAttribute("thegoal") Goal theGoal) {

        theGoal.setCurrentGoal(false);
        goalService.updateGoalToFinished(principal, theGoal);

        return "redirect:/home";

    }

    @PostMapping("/updateCurrentGoal")
    public String updateCurrentGoal(Principal principal, Goal goal) {

        // goal equals 0 when current goal is submitted to update current goal
        if(goal.getCurrentGoalStatus() == false && (goal.getId() != 0)) {

            goalService.setCurrentGoalById(principal, goal.getId());

        }

        return "redirect:/home";

    }

}
