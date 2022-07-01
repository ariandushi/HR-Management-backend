package com.internship.HRapp.dto.projectsDto;

import com.internship.HRapp.dto.projectsDto.ProjectsDTO;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ProjectAssignDTO {
    private List<ProjectsDTO> projects;
}