package com.internship.HRapp.dto.projectsDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class ProjectsDTO {
    private UUID projectId;
    private String projectName;
    private LocalDate startTime;
    private LocalDate endTime;
    private String description;
}
