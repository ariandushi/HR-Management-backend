package com.internship.HRapp.controller;

import com.internship.HRapp.dto.educationDto.EducationDto;
import com.internship.HRapp.service.interfaces.EducationInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "hr_management/education")
public class EducationController {

    private final EducationInterface educationInterface;

    @GetMapping("getAll")
    public ResponseEntity<List<EducationDto>> findEducations() {
        return ResponseEntity.ok(educationInterface.getEducations());
    }

    @GetMapping("getEducationById/{educationId}")
    public ResponseEntity<EducationDto> findEducationById(@PathVariable UUID educationId) {
        return ResponseEntity.ok(educationInterface.getEducationById(educationId));
    }

    @GetMapping("getEducationByUserId/{userId}")
    public ResponseEntity<List<EducationDto>> getEducationByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(educationInterface.getEducationByUserId(userId));
    }

    @PostMapping("addNewEducation")
    public ResponseEntity<EducationDto> createEducation(@RequestBody EducationDto educationDto) {
        return ResponseEntity.ok(educationInterface.addNewEducation(educationDto));
    }

    @PutMapping("updateEducation/{educationId}")
    public void editEducation(@PathVariable UUID educationId, @RequestBody EducationDto educationDto) {
        educationInterface.editEducation(educationId, educationDto);
    }

    @DeleteMapping("delete/{educationId}")
    public void deleteRolesById(@PathVariable UUID educationId) {
        educationInterface.deleteEducationById(educationId);
    }
}