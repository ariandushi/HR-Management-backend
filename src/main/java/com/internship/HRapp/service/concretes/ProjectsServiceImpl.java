package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.projectsDto.ProjectsDTO;
import com.internship.HRapp.dto.userDto.AssignUserDTO;
import com.internship.HRapp.entity.Projects;
import com.internship.HRapp.entity.User;
import com.internship.HRapp.mapper.ProjectsMapper;
import com.internship.HRapp.mapper.UserMapper;
import com.internship.HRapp.repository.ProjectsRepo;
import com.internship.HRapp.repository.UserRepo;
import com.internship.HRapp.service.interfaces.ProjectsServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectsServiceImpl implements ProjectsServiceInterface {

    private final ProjectsRepo projectsRepo;

    private final ProjectsMapper projectsMapper;
    private final UserMapper userMapper;
    private final UserRepo userRepo;

    @Override
    public List<ProjectsDTO> getProjectsByUserId(UUID userId) {
        var test = projectsMapper.entitiesToDtosProjects((projectsRepo.getProjectsByUsersUserId(userId)));
        return test;
    }

    public ProjectsDTO getProjectById(UUID projectId) {
        return projectsMapper.entityToDto((projectsRepo.getProjectsByProjectId(projectId)));
    }

    @Override
    public ProjectsDTO getProjectByProjectName(String projectName) {
        return projectsMapper.entityToDto(projectsRepo.findProjectsByProjectName(projectName));
    }

    @Override
    public ProjectsDTO addNewProjects(ProjectsDTO projectsDTO) {
        Projects createdProject = projectsRepo.save(projectsMapper.dtoToEntity(projectsDTO));
        return projectsMapper.entityToDto(createdProject);
    }

    @Override
    public void deleteProjectById(UUID projectsId) {
        projectsRepo.deleteById(projectsId);
    }

    @Override
    public ProjectsDTO updateProject(ProjectsDTO projectsDTO) {
        Projects projects = projectsRepo.getProjectsByProjectId(projectsDTO.getProjectId());
        projects.setProjectName(projectsDTO.getProjectName());
        projects.setStartTime(projectsDTO.getStartTime());
        projects.setEndTime(projectsDTO.getEndTime());
        projects.setDescription(projectsDTO.getDescription());
        projectsRepo.save(projects);
        return projectsMapper.entityToDto(projects);

    }

    @Override
    public AssignUserDTO assignUserToProject(UUID projectId, String username) {
        User user = userRepo.getByUsername(username);
        Projects project = projectsRepo.getProjectsByProjectId(projectId);
        if (project.getUsers().contains(user)
                && user.getProjects().contains(project)) {
            throw new IllegalStateException("This user already exists in the project");
        } else {
            project.getUsers().add(userRepo.getByUsername(username));
            projectsRepo.save(project);
        }
        return projectsMapper.toDTOAssignUser(projectsRepo.getById(projectId));
    }
    @Override
    public AssignUserDTO removeUserFromProject(UUID projectId, UUID userId) {
        Projects project = projectsRepo.getById(projectId);
        project.getUsers().removeIf(user1 -> user1.getUserId().equals(userId));
        projectsRepo.save(project);
        return projectsMapper.toDTOAssignUser(projectsRepo.getById(projectId));
    }
    @Override
    public ProjectsDTO getProjectByTask(UUID taskId){
        return projectsMapper.entityToDto(projectsRepo.getProjectsByTasksTaskId(taskId));
    }


    @Override
    public List<ProjectsDTO> getProjects() {
        return projectsMapper.entitiesToDtos(projectsRepo.findAll());
    }
}