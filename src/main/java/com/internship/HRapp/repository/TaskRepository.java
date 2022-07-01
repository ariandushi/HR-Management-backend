package com.internship.HRapp.repository;

import com.internship.HRapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    Task findTaskByTaskId(UUID taskId);

    List<Task> getTaskByUserUserId(UUID userId);

    List<Task> getTaskByProjectProjectId(UUID userId);

}
