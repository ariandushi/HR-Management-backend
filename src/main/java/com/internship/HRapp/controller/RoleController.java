package com.internship.HRapp.controller;

import com.internship.HRapp.dto.roleDto.RoleDTO;
import com.internship.HRapp.service.interfaces.RoleServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "hr_management/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleServiceInterface roleServiceInterface;

    @GetMapping("getAll")
    public ResponseEntity<List<RoleDTO>> findAllRoles() {
        return ResponseEntity.ok(roleServiceInterface.getRoles());
    }

    @GetMapping("id/{roleId}")
    public ResponseEntity<RoleDTO> findRoleById(@PathVariable UUID roleId) {
        return ResponseEntity.ok(roleServiceInterface.getRoleById(roleId));
    }

    @GetMapping("name/{roleName}")
    public ResponseEntity<RoleDTO> findRoleByName(@PathVariable String roleName) {
        return ResponseEntity.ok(roleServiceInterface.getRoleByRoleName(roleName));
    }

    @PostMapping("addRole")
    public ResponseEntity<RoleDTO> createNewRole(@RequestBody RoleDTO roleDTO) {
        return ResponseEntity.ok(roleServiceInterface.addNewRoles(roleDTO));
    }
    @GetMapping("getRoleByUserId/{userId}")
    public ResponseEntity<List<RoleDTO>> getRoleByUser(@PathVariable UUID userId){
        return ResponseEntity.ok(roleServiceInterface.getRoleByUserId(userId));
    }
    @DeleteMapping("delete/{roleId}")
    public void deleteRolesById(@PathVariable UUID roleId) {
        roleServiceInterface.deleteRolesById(roleId);
    }

    @PutMapping("updateRole/{roleId}")
    public void updateRole(@RequestParam RoleDTO roleDTO) {
        roleServiceInterface.updateRole(roleDTO);
    }
}
