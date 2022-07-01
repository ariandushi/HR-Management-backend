package com.internship.HRapp.controller;

import com.internship.HRapp.dto.userDto.AssignUserDTO;
import com.internship.HRapp.dto.projectsDto.ProjectsDTO;
import com.internship.HRapp.service.interfaces.ProjectsServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "hr_management/projects")
public class ProjectsController {
    private final ProjectsServiceInterface projectsServiceInterface;

    @PostMapping("/addProject")
    public ResponseEntity<ProjectsDTO> save(@RequestBody ProjectsDTO projectsDTO){
        return  ResponseEntity.ok(projectsServiceInterface.addNewProjects(projectsDTO));
    }
    @GetMapping("/projects/{userId}")
    public ResponseEntity<List<ProjectsDTO>> getProjectsByUserId(@PathVariable UUID userId){
        return ResponseEntity.ok(projectsServiceInterface.getProjectsByUserId(userId));
    }
    @GetMapping("/projects/id/{projectsId}")
    public ResponseEntity<ProjectsDTO> getProjectById(@PathVariable UUID projectsId){
        return ResponseEntity.ok(projectsServiceInterface.getProjectById(projectsId));
    }
    @GetMapping("getByTask/{taskId}")
    public ResponseEntity<ProjectsDTO> getProjectsByTask(@PathVariable UUID taskId){
        return ResponseEntity.ok(projectsServiceInterface.getProjectByTask(taskId));
    }
    @GetMapping("/projects/name/{projectsName}")
    public ResponseEntity<ProjectsDTO> findProjectByName(@PathVariable String projectsName){
        return ResponseEntity.ok(projectsServiceInterface.getProjectByProjectName(projectsName));
    }
    @GetMapping("/projects")
    public ResponseEntity<List<ProjectsDTO>>getProjects(){
        return ResponseEntity.ok(projectsServiceInterface.getProjects());
    }
    @PutMapping("/projects/updateProject/{projectId}")
    public void updateProject(@RequestBody ProjectsDTO projectsDTO){
        projectsServiceInterface.updateProject(projectsDTO);
    }
    @PatchMapping("assignUser/{projectId}/username/{username}")
    public ResponseEntity<AssignUserDTO> assignUserToProject(@PathVariable UUID projectId, @PathVariable String username){
        return ResponseEntity.ok(projectsServiceInterface.assignUserToProject(projectId, username));
    }
    @DeleteMapping("/projects/deleteProject/{projectId}")
    public void deleteProject(@PathVariable UUID projectId){
        projectsServiceInterface.deleteProjectById(projectId);
    }
    @PatchMapping("removeUser/{projectId}/userId/{userId}")
    public ResponseEntity<AssignUserDTO> removeUserFromProject(@PathVariable UUID projectId, @PathVariable UUID userId) {
        return ResponseEntity.ok(projectsServiceInterface.removeUserFromProject(projectId, userId));
    }
}