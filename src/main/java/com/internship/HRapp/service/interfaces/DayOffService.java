package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.dayOffDto.CreateDayOffDTO;
import com.internship.HRapp.dto.dayOffDto.StatusDTO;
import com.internship.HRapp.dto.dayOffDto.UserDayOffDTO;

import java.util.List;
import java.util.UUID;

public interface DayOffService {

    UserDayOffDTO placeDayOffRequest(CreateDayOffDTO requestDTO);

    void deleteDayOff(UUID dayOffId);

    void updateDayOffRequest(StatusDTO status);

    List<UserDayOffDTO> getUserDayOff(UUID userId);

    List<UserDayOffDTO> getAllDaysOff();

    UserDayOffDTO getDayOffById(UUID dayOffId);
}
