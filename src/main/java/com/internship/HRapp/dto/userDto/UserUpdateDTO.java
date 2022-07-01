package com.internship.HRapp.dto.userDto;

import lombok.Data;
import org.w3c.dom.Text;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class UserUpdateDTO {
    private UUID userId;
    @Column(unique = true)
    private String username;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private LocalDate dateOfBirth;
    private Double leaveDaysLeft;
    private String mobile;
    private LocalDate startingDay;
    private LocalDate terminationDay;
    private String secondContact;
    private Boolean usersStatus;
}