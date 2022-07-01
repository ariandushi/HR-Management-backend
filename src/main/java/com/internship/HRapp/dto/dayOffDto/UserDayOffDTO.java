package com.internship.HRapp.dto.dayOffDto;

import com.internship.HRapp.enums.DayOffPermission;
import com.internship.HRapp.enums.DayOffStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class UserDayOffDTO {
    private UUID userId;
    private UUID dayOffId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double dayOffAmount;
    private DayOffStatus requestStatus;
    private DayOffPermission dayOffPermission;
    private UUID idOfApprove;
    private UserOffDTO users;
    private String reason;
    private String report;

}
