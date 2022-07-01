package com.internship.HRapp.controller;

import com.internship.HRapp.dto.certificationDto.CertificationDto;
import com.internship.HRapp.service.concretes.CertificationService;
import com.internship.HRapp.service.interfaces.CertificationServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "hr_management/certification")
public class CertificationController {

    private final CertificationServiceInterface certificationServiceInterface;

    @GetMapping("getAll")
    public ResponseEntity<List<CertificationDto>> findCertifications() {
        return ResponseEntity.ok(certificationServiceInterface.getCertifications());}
    @GetMapping("getCertificationById/{certificationID}")
    public ResponseEntity<CertificationDto> findCertificationById(@PathVariable UUID certificationID){
        return ResponseEntity.ok(certificationServiceInterface.getCertificationById(certificationID));
    }
    @GetMapping("getCertificationsByUserId/{userId}")
    public ResponseEntity<List<CertificationDto>> getCertificationsByUserId(@PathVariable UUID userId){
        return ResponseEntity.ok(certificationServiceInterface.getCertificationByUserId(userId));
    }
    @PostMapping("addNewCertification")
    public ResponseEntity<CertificationDto> createCertification(@RequestBody CertificationDto certificationDto){
        return ResponseEntity.ok(certificationServiceInterface.addNewCertification(certificationDto));
    }
    @PutMapping("editCertification/{certificationID}")
    public void editCertification(@RequestBody CertificationDto certificationDto){
        certificationServiceInterface.editCertification(certificationDto); }

    @DeleteMapping("deleteCertification/{certificationID}")
    public void deleteRolesById(@PathVariable UUID certificationID) {
        certificationServiceInterface.deleteCertificationById(certificationID);
    }
}