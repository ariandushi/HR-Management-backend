package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.dayOffDto.CreateDayOffDTO;
import com.internship.HRapp.dto.dayOffDto.StatusDTO;
import com.internship.HRapp.dto.dayOffDto.UserDayOffDTO;
import com.internship.HRapp.entity.DayOff;
import com.internship.HRapp.entity.User;
import com.internship.HRapp.enums.DayOffPermission;
import com.internship.HRapp.enums.DayOffStatus;
import com.internship.HRapp.mapper.DayOffMapper;
import com.internship.HRapp.repository.DayOffRepository;
import com.internship.HRapp.repository.UserRepo;
import com.internship.HRapp.service.interfaces.DayOffService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
@RequiredArgsConstructor
@EnableScheduling

public class DayOffServiceImpl implements DayOffService {

    private final DayOffRepository dayOffRepo;

    private final DayOffMapper dayOffMapper;

    private final UserRepo userRepo;

    @Override
    public void updateDayOffRequest(StatusDTO status) {
        DayOff thisDayOff = dayOffRepo.findDayOffByDayOffId(status.getDayOffId());
        User approver = userRepo.findUserByUserId(status.getUserId());
        thisDayOff.setRequestStatus(status.getRequestStatus());
        thisDayOff.setIdOfApprove(approver.getUserId());
        thisDayOff.setRejectReason(status.getRejectReason());
        User user = userRepo.findByDaysOffDayOffId(status.getDayOffId());
        if (thisDayOff.getDayOffPermission().equals(DayOffPermission.DEFAULT)
                && thisDayOff.getRequestStatus().equals(DayOffStatus.APPROVED)) {
            if (thisDayOff.getDayOffAmount() == 0) {
                user.setLeaveDaysLeft(user.getLeaveDaysLeft() - 0.5);
            } else
                user.setLeaveDaysLeft((user.getLeaveDaysLeft() - thisDayOff.getDayOffAmount()));
            userRepo.save(user);
        }
        dayOffRepo.save(thisDayOff);
    }

    @Scheduled(cron = "0 30 09 * * *")
    public void updateLeaveDaysLeft() {
        var users = userRepo.findAll();
        for (var user : users) {
            long daysBetween = DAYS.between(user.getStartingDay(), LocalDate.now());
            if (daysBetween % 30 == 0) {
                user.setLeaveDaysLeft(user.getLeaveDaysLeft() + 1.7);
                userRepo.save(user);
            }
        }
    }

    public void deleteDayOff(UUID dayOffId) {
        boolean exists = dayOffRepo.existsById(dayOffId);
        if (!exists) {
            throw new IllegalStateException(
                    "dayOff with id " + dayOffId + " does not exist");
        }
        dayOffRepo.deleteById(dayOffId);
    }

    @Override
    public List<UserDayOffDTO> getUserDayOff(UUID userId) {
        return dayOffMapper.toDtos(dayOffRepo.getByUsersUserId(userId));
    }

    @Override
    public List<UserDayOffDTO> getAllDaysOff() {
        return dayOffMapper.toDtos(dayOffRepo.findAll());
    }

    @Override
    public UserDayOffDTO getDayOffById(UUID dayOffId) {
        return dayOffMapper.toDto(dayOffRepo.getById(dayOffId));
    }

    public UserDayOffDTO placeDayOffRequest(CreateDayOffDTO requestDTO) {
        DayOff created = dayOffRepo.save(dayOffMapper.toEntity(requestDTO));
        User user = userRepo.findByDaysOffDayOffId(created.getDayOffId());
        if (requestDTO.getDayOffAmount() > user.getLeaveDaysLeft()) {
            throw new RuntimeException("Can't make request, not enough days left");
        }
        return dayOffMapper.toDto(created);
    }
}

