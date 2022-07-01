package com.internship.HRapp.dto.dayOffDto;

import com.internship.HRapp.enums.DayOffPermission;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Getter
@Setter
public class CreateDayOffDTO {
    private UUID userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private DayOffPermission dayOffPermission;
    private String reason;
    private String report;
    @Transient
    private Double dayOffAmount;
    public Double getDayOffAmount(){
        return (double) ChronoUnit.DAYS.between(startDate, endDate);
}}
