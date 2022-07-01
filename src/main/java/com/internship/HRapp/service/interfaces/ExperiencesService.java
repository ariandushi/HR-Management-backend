package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.experienceDto.UserExperienceDTO;
import com.internship.HRapp.entity.Experiences;

import java.util.List;
import java.util.UUID;

public interface ExperiencesService {
    Experiences getExperienceById(UUID expId);

    List<UserExperienceDTO> getExperiences();

    UserExperienceDTO addNewExperiences(UserExperienceDTO experienceDTO);

    List<UserExperienceDTO> getExperiencesByUserId(UUID userId);

    UserExperienceDTO getExperiencesByExpId(UUID expId);

    void updateExperiences(UserExperienceDTO experienceDTO);

    void deleteExperienceByExpId(UUID expId);
}