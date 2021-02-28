package com.producedaily.productivityapp.goal.repository;

import com.producedaily.productivityapp.goal.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {

    List<Goal> findAllByUserId(long user_id);

    Goal findByUserId(long user_id);

    Goal findGoalById(long goal_id);

    void deleteGoalById(long goal_id);
}