package com.internship.HRapp.entity;

import com.internship.HRapp.enums.DayOffPermission;
import com.internship.HRapp.enums.DayOffStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table
public class DayOff {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID dayOffId;
    @Column(nullable = false)
    private LocalDate startDate;
    @Column(nullable = false)
    private LocalDate endDate;
    private String reason;
    @Enumerated(EnumType.STRING)
    private DayOffPermission dayOffPermission = DayOffPermission.DEFAULT;
    private String report;
    @Enumerated(EnumType.STRING)
    private DayOffStatus requestStatus = DayOffStatus.PENDING;
    private String rejectReason;
    private UUID idOfApprove;
    private Double dayOffAmount;

    @ManyToOne
    private User users;


}

