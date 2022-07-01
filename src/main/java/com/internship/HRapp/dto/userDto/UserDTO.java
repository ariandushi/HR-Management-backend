package com.internship.HRapp.dto.userDto;

import com.internship.HRapp.dto.projectsDto.ProjectsDTO;
import com.internship.HRapp.dto.roleDto.RoleDTO;
import com.internship.HRapp.dto.skillDto.SkillDTO;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
public class UserDTO {
    private UUID userId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean usersStatus;
    private Set<RoleDTO> roles;
    private Set<ProjectsDTO> projects;
    private List<SkillDTO> skills;
}
