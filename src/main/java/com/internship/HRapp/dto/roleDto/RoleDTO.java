package com.internship.HRapp.dto.roleDto;

import lombok.Data;
import java.util.UUID;

@Data
public class RoleDTO {
    private UUID roleId;
    private String roleName;
}
