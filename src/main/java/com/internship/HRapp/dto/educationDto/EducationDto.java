package com.internship.HRapp.dto.educationDto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Getter

public class EducationDto {
    private UUID userId;
    private UUID educationId;
    private String degree;
    private String universityName;
    private String facultyName;
    private LocalDate startTime;
    private LocalDate endTime;
    private String average;
    private String activeStatus;
}