package com.internship.HRapp.repository;

import com.internship.HRapp.dto.educationDto.EducationDto;
import com.internship.HRapp.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EducationRepository extends JpaRepository<Education, UUID> {

    List<Education> getEducationByUsersUserId(UUID userId);
}