package com.internship.HRapp.repository;

import com.internship.HRapp.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SkillRepo extends JpaRepository<Skill, UUID> {
    Skill findBySkillName(String skillName);
    List<Skill> getSkillsByUsersUserId(UUID userId);
}