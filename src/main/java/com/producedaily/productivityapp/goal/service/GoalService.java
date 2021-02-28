package com.producedaily.productivityapp.goal.service;

import com.producedaily.productivityapp.goal.model.Goal;

import java.security.Principal;
import java.util.List;

public interface GoalService {

    // finished and unfinished goals for day
    List<Goal> findAllDailyGoalsByUsername(Principal principal);

    List<Goal> findUnfinishedGoalsByUserName(Principal principal);

    Goal findCurrentGoalByUserName(Principal principal);

    Goal findGoalById(long goalId);

    void saveNewGoal(Principal principal, Goal goal);

    void updateGoalToFinished(Principal principal, Goal goal);

    void setInitialCurrentGoal(List<Goal> goals);

    void setCurrentGoalById(Principal principal, long goalId);

    void deleteGoalById(long goalId);

}
