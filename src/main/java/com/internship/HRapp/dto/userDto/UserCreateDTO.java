package com.internship.HRapp.dto.userDto;

import com.internship.HRapp.dto.roleDto.RoleDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class UserCreateDTO {
    private UUID userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private String mobile;
    private LocalDate startingDay;
    private String secondContact;
    private Double leaveDaysLeft;

    private Boolean usersStatus = true;
}
