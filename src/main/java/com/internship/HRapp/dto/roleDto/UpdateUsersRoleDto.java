package com.internship.HRapp.dto.roleDto;

import lombok.Data;

import java.util.UUID;

@Data
public class UpdateUsersRoleDto {
    private UUID oldRoleId;
    private UUID newRoleId;
    private UUID userId;
}