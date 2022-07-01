package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.educationDto.EducationDto;

import java.util.List;
import java.util.UUID;

public interface EducationInterface {
    List<EducationDto> getEducations();

    EducationDto addNewEducation(EducationDto educationDto);

    void editEducation(UUID educationId, EducationDto educationDto);

    EducationDto getEducationById(UUID educationId);

    void deleteEducationById(UUID educationId);

    List<EducationDto> getEducationByUserId(UUID userId);
}