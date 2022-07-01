package com.internship.HRapp.controller;

import com.internship.HRapp.dto.experienceDto.UserExperienceDTO;
import com.internship.HRapp.service.interfaces.ExperiencesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "hr_management/experience")
public class ExperiencesController {
    private final ExperiencesService experiencesService;

    @PostMapping("/addExperiences")
    public ResponseEntity<UserExperienceDTO> save(@RequestBody UserExperienceDTO userExperienceDTO){
        return  ResponseEntity.ok(experiencesService.addNewExperiences(userExperienceDTO));
    }

    @GetMapping("/experiences")
    public ResponseEntity<List<UserExperienceDTO>>getExperiences(){
        return ResponseEntity.ok(experiencesService.getExperiences());
    }

    @GetMapping("/experiences/getExperiencesByUserId/{userId}")
    public ResponseEntity<List<UserExperienceDTO>> getExperiencesByUserId(@PathVariable UUID userId){
        return ResponseEntity.ok(experiencesService.getExperiencesByUserId(userId));
    }

    @GetMapping("/experiences/getExperiencesByExpId/{expId}")
    public ResponseEntity<UserExperienceDTO> getExperiencesByExpId(@PathVariable UUID expId){
        return ResponseEntity.ok(experiencesService.getExperiencesByExpId(expId));
    }

    @PutMapping("/experiences/updateExperience/{expId}")
    public void updateExperiences(@RequestBody UserExperienceDTO userExperienceDTO){
        experiencesService.updateExperiences(userExperienceDTO);
    }
    @DeleteMapping("experiences/deleteExperience/{expId}")
    public void deleteExperience(@PathVariable UUID expId){
        experiencesService.deleteExperienceByExpId(expId);

    }
}