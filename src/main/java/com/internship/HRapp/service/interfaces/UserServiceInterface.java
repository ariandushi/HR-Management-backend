package com.internship.HRapp.service.interfaces;


import com.internship.HRapp.dto.loginDto.AuthResponseDTO;
import com.internship.HRapp.dto.loginDto.UserLoginDTO;
import com.internship.HRapp.dto.projectsDto.ProjectAssignDTO;
import com.internship.HRapp.dto.roleDto.AssignRoleDTO;
import com.internship.HRapp.dto.roleDto.UpdateRoleDTO;
import com.internship.HRapp.dto.roleDto.UpdateUsersRoleDto;
import com.internship.HRapp.dto.skillDto.UpdateSkillDTO;
import com.internship.HRapp.dto.userDto.*;

import java.util.List;
import java.util.UUID;

public interface UserServiceInterface {

    ProjectAssignDTO assignProjectToUser(String username, UUID projectId);

    UserUpdateDTO getWholeUserById(UUID userId);

    UserDTO getUserById(UUID userId);

    UserDTO getUserByUsername(String username);

    PasswordDTO getUserPassword(UUID userId);

    List<UserDTO> getUsers();

    void assignRole(AssignRoleDTO assignRoleDTO);

    UserCreateDTO addNewUser(UserCreateDTO userCreateDTO) throws Exception;

    UserUpdateDTO updateUser(UserUpdateDTO userUpdateDTO);

    UserDTO updateUsersStatus(UUID userId, UsersStatusDTO usersStatusDTO);

    UsernameDTO updateUsername(UUID userId, UsernameDTO usernameDTO);

    AssignRoleDTO assignRoleToUser(UUID userId, UUID roleId);

    UpdateRoleDTO removeRoleFromUser(UUID userId, UUID roleId);

    ProjectAssignDTO removeProjectFromUser(UUID userId, UUID projectId);

    UpdateRoleDTO updateRole(UUID userId, UpdateUsersRoleDto usersRoleDto);

    List<UserDTO> getUserByRoleId(UUID roleId);

    List<UserDTO> getUserByProjectId(UUID projectId);

    AuthResponseDTO login(UserLoginDTO loginDTO) throws Exception;

    void changePassword(PasswordDTO passwordUpdate);

    List<UserDTO> getUserBySkillId(UUID skillId);

    UpdateSkillDTO assignSkillToUser(UUID userId, UUID skillId);

    UpdateSkillDTO removeSkillFromUser(UUID userId, UUID skillId);
}