package com.internship.HRapp.dto.skillDto;

import lombok.Data;

import java.util.List;

@Data
public class UpdateSkillDTO {
    private List<SkillDTO> skills;
}