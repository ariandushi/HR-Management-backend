package com.internship.HRapp.repository;

import com.internship.HRapp.entity.Experiences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExperiencesRepo extends JpaRepository<Experiences, UUID> {

    List<Experiences> findByUsersUserId(UUID userId);
    Experiences getExperiencesByExpId(UUID expId);
    List<Experiences> getByUsersUserId(@Param("userId") UUID userId);
}