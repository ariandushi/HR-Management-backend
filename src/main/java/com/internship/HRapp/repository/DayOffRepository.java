package com.internship.HRapp.repository;

import com.internship.HRapp.entity.DayOff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DayOffRepository
        extends JpaRepository<DayOff, UUID> {

    DayOff findDayOffByDayOffId(UUID dayOffId);

    List<DayOff> getByUsersUserId(UUID userId);


}
