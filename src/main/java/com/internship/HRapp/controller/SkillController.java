package com.internship.HRapp.controller;

import com.internship.HRapp.dto.roleDto.RoleDTO;
import com.internship.HRapp.dto.skillDto.SkillDTO;
import com.internship.HRapp.service.interfaces.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "hr_management/skill")
@RequiredArgsConstructor
public class SkillController {
    private final SkillService skillService;

    @GetMapping("getAll")
    public ResponseEntity<List<SkillDTO>> findAllSkills() {
        return ResponseEntity.ok(skillService.getSkills());
    }

    @GetMapping("getSkillById/{skillId}")
    public ResponseEntity<SkillDTO> findSkillById(@PathVariable UUID skillId) {
        return ResponseEntity.ok(skillService.getSkillById(skillId));
    }

    @GetMapping("getSkillByName/{skillName}")
    public ResponseEntity<SkillDTO> findSkillByName(@PathVariable String skillName) {
        return ResponseEntity.ok(skillService.getSkillBySkillName(skillName));
    }

    @PostMapping("addSkill")
    public ResponseEntity<SkillDTO> createNewSkill(@RequestBody SkillDTO skillDTO) {
        return ResponseEntity.ok(skillService.addNewSkill(skillDTO));
    }

    @DeleteMapping("delete/{skillId}")
    public void deleteSkillById(@PathVariable UUID skillId) {
        skillService.deleteSkillById(skillId);
    }

    @PutMapping("updateSkill")
    public void updateSkill(@RequestBody SkillDTO skillDTO) {
        skillService.updateSkill(skillDTO);
    }

    @GetMapping("getSkillByUserId/{userId}")
    public ResponseEntity<List<SkillDTO>> getSkillByUser(@PathVariable UUID userId){
        return ResponseEntity.ok(skillService.getSkillsByUserId(userId));
    }
}