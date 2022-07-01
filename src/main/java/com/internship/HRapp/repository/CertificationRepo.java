package com.internship.HRapp.repository;

import com.internship.HRapp.entity.Certification;
import com.internship.HRapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CertificationRepo extends JpaRepository<Certification, UUID> {
    List<Certification> getCertificationByUsersUserId(UUID userId);
}