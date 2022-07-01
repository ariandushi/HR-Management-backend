package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.roleDto.RoleDTO;
import com.internship.HRapp.entity.Role;
import com.internship.HRapp.mapper.RoleMapper;
import com.internship.HRapp.repository.RoleRepo;
import com.internship.HRapp.repository.UserRepo;
import com.internship.HRapp.service.interfaces.RoleServiceInterface;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleServiceInterface {

    private final RoleRepo rolesRepo;
    private final RoleMapper roleMapper;

    @Override
    public RoleDTO getRoleById(UUID roleId) {
        return roleMapper.toDTO(rolesRepo.getById(roleId));
    }

    @Override
    public RoleDTO getRoleByRoleName(String roleName) {
        return roleMapper.toDTO(rolesRepo.findByRoleName(roleName));
    }

    @Override
    public List<RoleDTO> getRoles() {
        return roleMapper.toDTOs(rolesRepo.findAll());
    }

    @Override
    public RoleDTO addNewRoles(RoleDTO roleDTO) {
        Role createdRole = roleMapper.toEntity(roleDTO);
        createdRole.setRoleName(createdRole.getRoleName());
        rolesRepo.save(createdRole);
        return roleMapper.toDTO(createdRole);
    }

    @Override
    public void deleteRolesById(UUID roleId) {
        rolesRepo.deleteById(roleId);
    }

    @Override
    public RoleDTO updateRole(RoleDTO roleDTO) {
        Role role = roleMapper.toEntity(roleDTO);
        rolesRepo.save(role);
        return roleMapper.toDTO(role);
    }

    @Override
    public List<RoleDTO> getRoleByUserId(UUID userId) {
        return roleMapper.toDTOs(rolesRepo.getRoleByUsersUserId(userId));
    }
}