package com.internship.HRapp.dto.userDto;

import lombok.Data;

import java.util.UUID;

@Data
public class UsersStatusDTO {
    private UUID userId;
    private Boolean usersStatus;
}
