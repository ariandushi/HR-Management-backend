package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.skillDto.SkillDTO;

import java.util.List;
import java.util.UUID;

public interface SkillService {

    SkillDTO getSkillById(UUID skillId);

    SkillDTO getSkillBySkillName(String skillName);

    List<SkillDTO> getSkills();

    SkillDTO addNewSkill(SkillDTO skillDTO);

    void deleteSkillById(UUID skillId);

    SkillDTO updateSkill(SkillDTO skillDTO);

    List<SkillDTO> getSkillsByUserId(UUID userId);
}