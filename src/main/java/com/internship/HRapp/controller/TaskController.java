package com.internship.HRapp.controller;

import com.internship.HRapp.dto.taskDto.TaskAssignDTO;
import com.internship.HRapp.dto.taskDto.TaskDTO;
import com.internship.HRapp.service.interfaces.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "hr_management/task")
public class TaskController {
    private final TaskService taskService;

    @PostMapping("newTask")
    public ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO newDTO) {
        return ResponseEntity.ok(taskService.addTask(newDTO));

    }

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(@PathVariable("taskId") UUID taskId) {
        taskService.deleteTask(taskId);

    }

    @PatchMapping ("assignTask/{taskId}/userId/{userId}")
    public ResponseEntity<String> assignTask(@PathVariable UUID taskId, @PathVariable UUID userId) {
        return ResponseEntity.ok(taskService.assignTask(taskId, userId));

    }

    @GetMapping("userId/{userId}")
    public ResponseEntity<List<TaskDTO>> getTasksByUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok(taskService.getTasksByUserId(userId));
    }

    @GetMapping("projectId/{projectId}")
    public ResponseEntity<List<TaskDTO>> getTasksByProjectId(@PathVariable UUID projectId) {
        return ResponseEntity.ok(taskService.getTasksByProjectId(projectId));
    }
    @PatchMapping("finishedTask/{taskId}")
    public ResponseEntity<String> finishedTask(@PathVariable UUID taskId){
        return ResponseEntity.ok(taskService.finishedTask(taskId));
    }

    @GetMapping("getTaskById/{taskId}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable UUID taskId) {
        return ResponseEntity.ok(taskService.getTaskById(taskId));
    }
}
