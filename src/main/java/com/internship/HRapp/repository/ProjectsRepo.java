package com.internship.HRapp.repository;

import com.internship.HRapp.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProjectsRepo extends JpaRepository<Projects, UUID> {

    Projects getProjectsByProjectId(UUID projectId);

    List<Projects> getProjectsByUsersUserId(UUID userId);

    Projects findProjectsByProjectName(String projectName);
    Projects getProjectsByTasksTaskId(UUID taskId);
}