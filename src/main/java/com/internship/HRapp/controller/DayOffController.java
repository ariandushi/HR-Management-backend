package com.internship.HRapp.controller;

import com.internship.HRapp.dto.dayOffDto.CreateDayOffDTO;
import com.internship.HRapp.dto.dayOffDto.StatusDTO;
import com.internship.HRapp.dto.dayOffDto.UserDayOffDTO;
import com.internship.HRapp.service.interfaces.DayOffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "hr_management/dayOff")
public class DayOffController {

    private final DayOffService dayOffService;

    @PostMapping("/placeDayOffRequest")
    public ResponseEntity<UserDayOffDTO> placeDayOffRequest(@RequestBody CreateDayOffDTO requestDTO) {
        return ResponseEntity.ok(dayOffService.placeDayOffRequest(requestDTO));
    }

    @GetMapping("getUserDayOff/{userId}")
    public ResponseEntity<List<UserDayOffDTO>> getUserDaysOff(@PathVariable UUID userId) {
        return ResponseEntity.ok(dayOffService.getUserDayOff(userId));
    }

    @GetMapping("/getAllDaysOff")
    public ResponseEntity<List<UserDayOffDTO>> getAllDaysOff(){
        return ResponseEntity.ok(dayOffService.getAllDaysOff());
    }

    @PatchMapping(path = "/approveDayOff")
    public void updateDayOffRequest(@RequestBody StatusDTO status) {
        dayOffService.updateDayOffRequest(status);
    }


    @DeleteMapping(path = "delete/{dayOffId}")
    public void deleteDayOff(@PathVariable("dayOffId") UUID dayOffId) {
        dayOffService.deleteDayOff(dayOffId);
    }

    @GetMapping(path = "getDayOff/{dayOffId}")
    public ResponseEntity<UserDayOffDTO> getDayOffById(@PathVariable UUID dayOffId){
      return ResponseEntity.ok(dayOffService.getDayOffById(dayOffId));
    }
}
