package com.internship.HRapp.dto.experienceDto;

import com.internship.HRapp.enums.TrustLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class UserExperienceDTO {
    private UUID userId;
    private UUID expId;
    private String company;
    private String position;
    private LocalDate startTime;
    private LocalDate endTime;
    private String description;
    private TrustLevel trustLevel;
}