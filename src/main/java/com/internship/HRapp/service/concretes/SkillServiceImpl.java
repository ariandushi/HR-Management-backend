package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.skillDto.SkillDTO;
import com.internship.HRapp.entity.Skill;
import com.internship.HRapp.mapper.SkillMapper;
import com.internship.HRapp.repository.SkillRepo;
import com.internship.HRapp.service.interfaces.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillRepo skillRepo;
    private final SkillMapper skillMapper;

    @Override
    public SkillDTO getSkillById(UUID skillId) {
        return skillMapper.toDTO(skillRepo.getById(skillId));
    }

    @Override
    public SkillDTO getSkillBySkillName(String skillName) {
        return skillMapper.toDTO(skillRepo.findBySkillName(skillName));
    }

    @Override
    public List<SkillDTO> getSkills() {
        return skillMapper.toDTOs(skillRepo.findAll());
    }

    @Override
    public SkillDTO addNewSkill(SkillDTO skillDTO) {
        Skill createdSkill = skillMapper.toEntity(skillDTO);
        skillRepo.save(createdSkill);
        return skillMapper.toDTO(createdSkill);
    }

    @Override
    public void deleteSkillById(UUID skillId) {
        skillRepo.deleteById(skillId);
    }

    @Override
    public SkillDTO updateSkill(SkillDTO skillDTO) {
        Skill skill = skillMapper.toEntity(skillDTO);
        skillRepo.save(skill);
        return skillMapper.toDTO(skill);
    }

    @Override
    public List<SkillDTO> getSkillsByUserId(UUID userId) {
        return skillMapper.toDTOs(skillRepo.getSkillsByUsersUserId(userId));
    }
}