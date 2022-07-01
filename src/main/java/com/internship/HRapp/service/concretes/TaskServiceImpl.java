package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.taskDto.TaskAssignDTO;
import com.internship.HRapp.dto.taskDto.TaskDTO;
import com.internship.HRapp.entity.Task;
import com.internship.HRapp.enums.TaskStatus;
import com.internship.HRapp.mapper.TaskMapper;
import com.internship.HRapp.repository.TaskRepository;
import com.internship.HRapp.repository.UserRepo;
import com.internship.HRapp.service.interfaces.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepo;
    private final TaskMapper taskMapper;
    private final UserRepo userRepo;

    @Override
    public TaskDTO addTask(TaskDTO newDTO) {
        Task task = taskRepo.save(taskMapper.taskToEntity(newDTO));
        return taskMapper.taskToDto(task);
    }

    @Override
    public String assignTask(UUID taskId, UUID userId) {
        Task task = taskRepo.findTaskByTaskId(taskId);
        task.setUser(userRepo.getById(userId));
        task.setTaskStatus(TaskStatus.ASSIGNED);
        taskRepo.save(task);
        return "assign successful";
    }

    @Override
    public void deleteTask(UUID taskId) {
        boolean exists = taskRepo.existsById(taskId);
        if (!exists) {
            throw new IllegalStateException(
                    "task with id " + taskId + " does not exist");
        }
        taskRepo.deleteById(taskId);
    }

    @Override
    public List<TaskDTO> getTasksByUserId(UUID userId) {
        return taskMapper.taskListToDto(taskRepo.getTaskByUserUserId(userId));
    }

    @Override
    public List<TaskDTO> getTasksByProjectId(UUID projectId) {
        return taskMapper.taskListToDto(taskRepo.getTaskByProjectProjectId(projectId));

    }

    @Override
    public String finishedTask(UUID taskId) {
        Task task = taskRepo.findTaskByTaskId(taskId);
        task.setTaskStatus(TaskStatus.FINISHED);
        taskRepo.save(task);
        return "Task finished";
    }
    @Override
    public TaskDTO getTaskById(UUID taskId) {
        return taskMapper.taskToDto(taskRepo.findTaskByTaskId(taskId));
    }

}
