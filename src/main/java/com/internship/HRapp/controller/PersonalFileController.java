package com.internship.HRapp.controller;

import com.internship.HRapp.dto.personalFileDto.PersonalFileDTO;
import com.internship.HRapp.service.interfaces.PersonalFileInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "hr_management/personalFile")
@RequiredArgsConstructor
public class PersonalFileController {
    private final PersonalFileInterface personalFileServiceInterface;

    @GetMapping("getAll")
    public ResponseEntity<List<PersonalFileDTO>> findAllPersonalFiles() {
        return ResponseEntity.ok(personalFileServiceInterface.getPersonalFiles());
    }

    @PostMapping("addNewPersonalFile")
    public ResponseEntity<PersonalFileDTO> createNewPersonalFile(@RequestBody PersonalFileDTO personalFileDto) {
        return ResponseEntity.ok(personalFileServiceInterface.addNewPersonalFile(personalFileDto));
    }

    @PutMapping("editPersonalFile/{personalFileId}")
    public ResponseEntity<PersonalFileDTO> editPersonalFile(@RequestBody PersonalFileDTO personalFileDto) {
        return ResponseEntity.ok(personalFileServiceInterface.editPersonalFile(personalFileDto));
    }

    @GetMapping("getPersonalFile/{personalFileId}")
    public ResponseEntity<PersonalFileDTO> findPersonalFileById(@PathVariable UUID personalFileId) {
        return ResponseEntity.ok(personalFileServiceInterface.getPersonalFileById(personalFileId));
    }

    @GetMapping("getPersonalFileByUser/{userId}")
    public ResponseEntity<List<PersonalFileDTO>> getPersonalFileByUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok(personalFileServiceInterface.getPersonalFileByUserId(userId));
    }

    @DeleteMapping("deletePersonalFile/{personalFileId}")
    public void deleteRolesById(@PathVariable UUID personalFileId) {
        personalFileServiceInterface.deletePersonalFileById(personalFileId);
    }
}