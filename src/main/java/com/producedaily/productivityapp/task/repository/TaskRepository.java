package com.producedaily.productivityapp.task.repository;

import com.producedaily.productivityapp.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByUserId(long user_id);

    boolean existsById(long user_id);

    Task findByUserId(long user_id);
}