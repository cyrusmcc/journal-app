package com.producedaily.productivityapp.goal.service;

import com.producedaily.productivityapp.goal.model.Goal;
import com.producedaily.productivityapp.journal.model.JournalEntry;
import com.producedaily.productivityapp.journal.service.JournalService;
import com.producedaily.productivityapp.goal.repository.GoalRepository;
import com.producedaily.productivityapp.user.model.User;
import com.producedaily.productivityapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoalServiceImpl implements GoalService {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private UserService userService;

    @Autowired
    JournalService journalService;

    @Override
    public List<Goal> findAllDailyGoalsByUsername(Principal principal) {

        User user = userService.findByUsername(principal.getName());

        List<Goal> allUserGoals = user.getGoals();

        user.deletePastGoals(allUserGoals);

        return allUserGoals;
    }

    @Override
    public List<Goal> findUnfinishedGoalsByUserName(Principal principal) {

        User user = userService.findByUsername(principal.getName());

        List<Goal> userGoals = user.getGoals();

        List<Goal> unfinishedGoals = user.getFinishedGoals(userGoals);

        return unfinishedGoals;
    }

    @Override
    public Goal findCurrentGoalByUserName(Principal principal) {

        List<Goal> goals =  findUnfinishedGoalsByUserName(principal);

        Goal currentGoal = null;

        for(int i = 0; i < goals.size(); i++) {

            if(goals.get(i).isCurrentGoal(true) == true) {
                currentGoal = goals.get(i);
            }

        }
        return currentGoal;
    }

    @Override
    public Goal findGoalById(long goalId) {

        return goalRepository.findGoalById(goalId);
    }

    @Override
    public void saveNewGoal(Principal principal, Goal goal) {

        User user = userService.findByUsername(principal.getName());

        goal.setUser(user);

        goal.setFinished(false);

        goal.setGoalDate(user.getLocalDate());

        goal.setGoalPeriod(goal.getGoalPeriod());

        goal.setGoalOccurrence(goal.getGoalOccurrence());

        goalRepository.save(goal);

        setInitialCurrentGoal(user.getGoals());
    }

    // first unfinished goal set to current until user specifies new current goal
    public void setInitialCurrentGoal(List<Goal> goals) {

        List<Goal> unfinshedGoals = new ArrayList<>();
        boolean currentgoalExists = false;

        for(int i = 0; i < goals.size(); i++) {

            if(goals.get(i).isFinished() == false) {

                Goal unfinishedGoal = goals.get(i);

                unfinshedGoals.add(unfinishedGoal);
            }

            currentgoalExists = unfinshedGoals.stream().anyMatch(
                    goal -> goal.isCurrentGoal(true));

        }

        if((currentgoalExists == false) && (!unfinshedGoals.isEmpty())) {

            Goal newCurrentGoal = unfinshedGoals.get(0);

            newCurrentGoal.setCurrentGoal(true);

            goalRepository.save(newCurrentGoal);
        }
        else if(unfinshedGoals.isEmpty()) {

        }
    }

    @Override
    public void setCurrentGoalById(Principal principal, long goalId) {

        Goal goal = goalRepository.findGoalById(goalId);

        List<Goal> userGoals = userService.findgoals(principal);

        for(int i = 0; i < userGoals.size(); i++) {
            userGoals.get(i).setCurrentGoal(false);
        }

        goal.setCurrentGoal(true);

        goalRepository.save(goal);

    }

    @Override
    public void deleteGoalById(long goalId) {
        goalRepository.deleteGoalById(goalId);
    }

    @Override
    public void updateGoalToFinished(Principal principal, Goal goal) {

        // add goal note to journal before deletion
        if(goal.getNote() != null) {

            JournalEntry entry = journalService.findEntryByJournalAndDate(
                    journalService.findJournal(principal), goal.getGoalDate());

            if(entry.getGoalSummary() != null ) {

                String goalSummary = entry.getGoalSummary() + " ### " + goal.getName() + ": " + goal.getNote();

                entry.setGoalSummary(goalSummary);

                journalService.saveEntry(entry);

                deleteGoalById(goal.getId());
            }

            if(entry.getGoalSummary() == null) {

                String goalSummary = "### " + goal.getName() + ": " + goal.getNote();

                entry.setGoalSummary(goalSummary);

                journalService.saveEntry(entry);

                deleteGoalById(goal.getId());

            }
        }

        goal.setFinished(true);

        goalRepository.save(goal);

        setInitialCurrentGoal(userService.findgoals(principal));
    }
}