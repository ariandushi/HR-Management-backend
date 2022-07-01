package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.loginDto.AuthResponseDTO;
import com.internship.HRapp.dto.loginDto.UserLoginDTO;
import com.internship.HRapp.dto.projectsDto.ProjectAssignDTO;
import com.internship.HRapp.dto.roleDto.AssignRoleDTO;
import com.internship.HRapp.dto.roleDto.UpdateRoleDTO;
import com.internship.HRapp.dto.roleDto.UpdateUsersRoleDto;
import com.internship.HRapp.dto.skillDto.UpdateSkillDTO;
import com.internship.HRapp.dto.userDto.*;
import com.internship.HRapp.entity.Projects;
import com.internship.HRapp.entity.Role;
import com.internship.HRapp.entity.Skill;
import com.internship.HRapp.entity.User;
import com.internship.HRapp.mapper.ProjectsMapper;
import com.internship.HRapp.mapper.RoleMapper;
import com.internship.HRapp.mapper.SkillMapper;
import com.internship.HRapp.mapper.UserMapper;
import com.internship.HRapp.repository.RoleRepo;
import com.internship.HRapp.repository.SkillRepo;
import com.internship.HRapp.repository.UserRepo;
import com.internship.HRapp.security.MyUserDetails;
import com.internship.HRapp.service.interfaces.ProjectsServiceInterface;
import com.internship.HRapp.service.interfaces.RoleServiceInterface;
import com.internship.HRapp.service.interfaces.UserServiceInterface;
import com.internship.HRapp.service.interfaces.UtilityInterface;
import com.internship.HRapp.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.SendFailedException;
import java.io.NotActiveException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServiceInterface {
    private final UserRepo usersRepo;
    private final UserMapper usersMapper;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtTokenUtil;
    private final MyUserDetails myUserDetails;
    private final UtilityInterface utility;
    private final RoleServiceInterface roleService;
    private final RoleMapper roleMapper;
    private final ProjectsMapper projectsMapper;
    private final ProjectsServiceInterface projectsService;
    private final SkillRepo skillRepo;
    private final SkillMapper skillMapper;

    @Override
    public UserDTO getUserById(UUID userId) {
        return usersMapper.entityToDTO(usersRepo.getById(userId));
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        return usersMapper.entityToDTO(usersRepo.getByUsername(username));
    }

    @Override
    public PasswordDTO getUserPassword(UUID userId) {
        return usersMapper.toDTOPassword(usersRepo.getById(userId));
    }

    @Override
    public List<UserDTO> getUsers() {
        return usersMapper.entitiesToDTOs(usersRepo.findAll());
    }

    @Override
    public void assignRole(AssignRoleDTO assignRoleDTO) {
        User user = usersRepo.findUserByUserId(assignRoleDTO.getUserId());
        Role role = roleRepo.findRoleByRoleId(assignRoleDTO.getRoleId());
        user.getRoles().add(role);
    }

    @Override
    public UserCreateDTO addNewUser(UserCreateDTO userCreateDTO) throws Exception {
        userCreateDTO.setPassword(utility.generateRandomPassword(10));
        System.out.println(userCreateDTO.getPassword());
        try {
            utility.sendRegistrationEmail(userCreateDTO);
        } catch (SendFailedException e) {
            throw new Exception("Incorrect email", e);
        }
        userCreateDTO.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
        User createdUser = usersRepo.save(usersMapper.toEntity(userCreateDTO));

        return usersMapper.toDTO(createdUser);
    }

    @Override
    public UserUpdateDTO updateUser(UserUpdateDTO userUpdateDTO) {
        User user = usersRepo.findUserByUserId(userUpdateDTO.getUserId());
        user.setFirstName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());
        user.setUsername(userUpdateDTO.getUsername());
        user.setUsersStatus(userUpdateDTO.getUsersStatus());
        user.setEmail(userUpdateDTO.getEmail());
        user.setMobile(userUpdateDTO.getMobile());
        user.setDateOfBirth(userUpdateDTO.getDateOfBirth());
        user.setTerminationDay(userUpdateDTO.getTerminationDay());
        usersRepo.save(user);
        return usersMapper.toDTOUpdate(user);
    }

    @Override
    public UserDTO updateUsersStatus(UUID userId, UsersStatusDTO usersStatusDTO) {
        User user = usersRepo.getById(userId);
        user.setUsersStatus(usersStatusDTO.getUsersStatus());
        return usersMapper.entityToDTO(usersRepo.save(user));
    }

    @Override
    public UsernameDTO updateUsername(UUID userId, UsernameDTO usernameDTO) {
        User user = usersRepo.getById(userId);
        user.setUsername(usernameDTO.getUsername());
        return usersMapper.toDTOUsername(usersRepo.save(user));
    }

    @Override
    public AssignRoleDTO assignRoleToUser(UUID userId, UUID roleId) {
        User user = usersRepo.getById(userId);
        Role role = roleRepo.getById(roleId);
        if (role.getUsers().contains(user)
                && user.getRoles().contains(role)) {
            throw new IllegalStateException("This role has already been assigned to this user");
        } else {
            user.getRoles().add(role);
            usersRepo.save(user);
        }
        return usersMapper.toDTOAssign(usersRepo.getById(userId));
    }

    @Override
    public UpdateRoleDTO removeRoleFromUser(UUID userId, UUID roleId) {
        User user = usersRepo.getById(userId);
        user.getRoles().removeIf(role1 -> role1.getRoleId().equals(roleId));
        usersRepo.save(user);
        return usersMapper.toDTORole(usersRepo.getById(userId));
    }

    @Override
    public ProjectAssignDTO assignProjectToUser(String username, UUID projectId) {
        User user = usersRepo.getByUsername(username);
        Projects project = projectsMapper.dtoToEntity(projectsService.getProjectById(projectId));
        user.getProjects().add(project);
        usersRepo.save(user);
        return usersMapper.toDTOProject(usersRepo.getByUsername(username));
    }

    @Override
    public UserUpdateDTO getWholeUserById(UUID userId) {
        return usersMapper.toDTOUpdate(usersRepo.getById(userId));
    }

    @Override
    public ProjectAssignDTO removeProjectFromUser(UUID userId, UUID projectId) {
        User user = usersRepo.getById(userId);
        user.getProjects().removeIf(project -> project.getProjectId().equals(projectId));
        usersRepo.save(user);
        return usersMapper.toDTOProject(usersRepo.getById(userId));
    }

    @Override
    public UpdateRoleDTO updateRole(UUID userId, UpdateUsersRoleDto usersRoleDto) {
        User user = usersRepo.getById(userId);
        Role existingRole = user.getRoles()
                .stream()
                .filter(role -> role.getRoleId().equals(usersRoleDto.getOldRoleId()))
                .findAny().get();
        user.getRoles().remove(existingRole);
        Role newRole = roleMapper.toEntity(roleService.getRoleById(usersRoleDto.getNewRoleId()));
        user.getRoles().add(newRole);
        usersRepo.saveAndFlush(user);
        return usersMapper.toDTORole(usersRepo.getById(userId));
    }

    @Override
    public List<UserDTO> getUserByRoleId(UUID roleId) {
        return usersMapper.entitiesToDTOs(usersRepo.getUserByRolesRoleId(roleId));
    }

    @Override
    public List<UserDTO> getUserByProjectId(UUID projectId) {
        return usersMapper.entitiesToDTOs(usersRepo.getUserByProjectsProjectId(projectId));
    }

    @Override
    public AuthResponseDTO login(UserLoginDTO loginDTO) throws Exception {
        User user = usersRepo.getByUsername(loginDTO.getUsername());
        if (user.getUsersStatus()) {
            try {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
                );
            } catch (BadCredentialsException e) {
                throw new Exception("Incorrect username or password", e);
            }
            final UserDetails userDetails = myUserDetails
                    .loadUserByUsername(loginDTO.getUsername());
            final String jwt = jwtTokenUtil.generateToken(userDetails);
            final String refreshToken = jwtTokenUtil.generateRefreshToken(userDetails);
            return new AuthResponseDTO(jwt, refreshToken);
        }
        throw new NotActiveException("This user is not active");
    }

    @Override
    public void changePassword(PasswordDTO passwordUpdate) {
        User user = usersRepo.getById(passwordUpdate.getUserId());
        if (passwordEncoder.matches(passwordUpdate.getOldPassword(), user.getPassword())) {
            if (passwordUpdate.getNewPassword().length() >= 8) {
                user.setPassword(passwordEncoder.encode(passwordUpdate.getNewPassword()));
                usersRepo.save(user);
            } else throw new IllegalStateException("Password must have 8 or more characters");
        } else throw new IllegalStateException("Incorrect old password");

    }

    @Override
    public List<UserDTO> getUserBySkillId(UUID skillId) {
        return usersMapper.entitiesToDTOs(usersRepo.getUserBySkillsSkillId(skillId));
    }
    @Override
    public UpdateSkillDTO assignSkillToUser(UUID userId, UUID skillId) {
        User user = usersRepo.getById(userId);
        Skill skill = skillRepo.getById(skillId);
        if (skill.getUsers().contains(user)
                && user.getSkills().contains(skill)) {
            throw new IllegalStateException("This skill has already been assigned to this user");
        } else {
            user.getSkills().add(skill);
            usersRepo.save(user);
        }
        return usersMapper.toDTOSkill(usersRepo.getById(userId));
    }

    @Override
    public UpdateSkillDTO removeSkillFromUser(UUID userId, UUID skillId) {
        User user = usersRepo.getById(userId);
        user.getSkills().removeIf(skill1 -> skill1.getSkillId().equals(skillId));
        usersRepo.save(user);
        return usersMapper.toDTOSkill(usersRepo.getById(userId));
    }
}
