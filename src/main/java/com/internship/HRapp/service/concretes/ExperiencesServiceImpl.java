package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.experienceDto.UserExperienceDTO;
import com.internship.HRapp.entity.Experiences;
import com.internship.HRapp.mapper.ExperiencesMapper;
import com.internship.HRapp.repository.ExperiencesRepo;
import com.internship.HRapp.service.interfaces.ExperiencesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExperiencesServiceImpl implements ExperiencesService {

    private final ExperiencesRepo experiencesRepo;

    private final ExperiencesMapper experiencesMapper;

    @Override
    public Experiences getExperienceById(UUID expId) {
        return experiencesRepo.findById(expId).orElse(null);
    }

    @Override
    public UserExperienceDTO getExperiencesByExpId(UUID expId) {
        return experiencesMapper.entityToDto((experiencesRepo.findById(expId)).orElse(null));
    }

    @Override
    public List<UserExperienceDTO> getExperiences() {
        return experiencesMapper.entitiesToDtos(experiencesRepo.findAll());
    }

    @Override
    public UserExperienceDTO addNewExperiences(UserExperienceDTO experiencesDTO) {
        Experiences createdExperience = experiencesRepo.save(experiencesMapper.dtoToEntity(experiencesDTO));
        return experiencesMapper.entityToDto(createdExperience);
    }

    @Override
    public List<UserExperienceDTO> getExperiencesByUserId(UUID userId) {
        return experiencesMapper.entitiesToDtos((experiencesRepo.getByUsersUserId(userId)));
    }

    @Override
    public void updateExperiences(UserExperienceDTO userExperienceDTO) {
        Experiences experiences = experiencesRepo.getExperiencesByExpId(userExperienceDTO.getExpId());
        experiences.setCompany(userExperienceDTO.getCompany());
        experiences.setPosition(userExperienceDTO.getPosition());
        experiences.setStartTime(userExperienceDTO.getStartTime());
        experiences.setEndTime(userExperienceDTO.getEndTime());
        experiences.setDescription(userExperienceDTO.getDescription());
        experiences.setTrustLevel(userExperienceDTO.getTrustLevel());
        experiencesRepo.save(experiences);
    }

    @Override
    public void deleteExperienceByExpId(UUID expId) {
        experiencesRepo.deleteById(expId);
    }

}