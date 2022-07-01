package com.internship.HRapp.dto.roleDto;

import lombok.Data;

import java.util.List;

@Data
public class UpdateRoleDTO {
    private List<RoleDTO> roles;
}