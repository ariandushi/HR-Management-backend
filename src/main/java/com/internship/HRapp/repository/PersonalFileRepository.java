package com.internship.HRapp.repository;

import com.internship.HRapp.entity.Education;
import com.internship.HRapp.entity.PersonalFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PersonalFileRepository extends JpaRepository<PersonalFile, UUID> {

    List<PersonalFile> getPersonalFileByUsersUserId(UUID userId);
}