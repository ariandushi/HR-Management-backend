package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.projectsDto.ProjectsDTO;
import com.internship.HRapp.dto.userDto.AssignUserDTO;

import java.util.List;
import java.util.UUID;

public interface ProjectsServiceInterface {

    List<ProjectsDTO> getProjectsByUserId(UUID userId);

    AssignUserDTO removeUserFromProject(UUID projectId, UUID userId);

    ProjectsDTO getProjectByTask(UUID taskId);

    List<ProjectsDTO> getProjects();

    ProjectsDTO getProjectById(UUID projectId);

    ProjectsDTO getProjectByProjectName(String projectName);

    ProjectsDTO addNewProjects(ProjectsDTO projectsDTO);

    void deleteProjectById(UUID projectId);

    ProjectsDTO updateProject(ProjectsDTO projectsDTO);

    AssignUserDTO assignUserToProject(UUID projectId, String username);


}