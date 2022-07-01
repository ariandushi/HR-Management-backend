package com.internship.HRapp.repository;

import com.internship.HRapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
    User findByUsername(String username);
    User getByUsername(String username);
    User findUserByUserId(UUID userId);
    User findByDaysOffDayOffId(UUID dayOffId);
    List<User> getUserByRolesRoleId(UUID roleId);
    List<User> getUserByProjectsProjectId(UUID roleId);
    List<User> getUserBySkillsSkillId(UUID skillId);

}