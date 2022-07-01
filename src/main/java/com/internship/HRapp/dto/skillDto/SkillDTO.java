package com.internship.HRapp.dto.skillDto;

import lombok.Data;

import java.util.UUID;

@Data
public class SkillDTO {
    private UUID skillId;
    private String skillName;
}