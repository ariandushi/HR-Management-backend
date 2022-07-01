package com.internship.HRapp.controller;

import com.internship.HRapp.dto.addressDto.UserAddressDTO;
import com.internship.HRapp.service.interfaces.AddressServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "hr_management/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressServiceInterface addressServiceInterface;

    @GetMapping("getAll")
    public ResponseEntity<List<UserAddressDTO>> findAllAddresses() {
        return ResponseEntity.ok(addressServiceInterface.getAddresses());
    }

    @PostMapping("addNewAddress")
    public ResponseEntity<UserAddressDTO> createNewAddress(@RequestBody UserAddressDTO addressDto) {
        return ResponseEntity.ok(addressServiceInterface.addNewAddress(addressDto));
    }

    @PutMapping("editAddress/{addressID}")
    public void editAddress(@RequestBody UserAddressDTO addressDto) {
        addressServiceInterface.editAddress(addressDto);
    }

    @GetMapping("getAddressById/{addressID}")
    public ResponseEntity<UserAddressDTO> findAddressById(@PathVariable UUID addressID) {
        return ResponseEntity.ok(addressServiceInterface.getAddressById(addressID));
    }
    @GetMapping("getAddressByUserId/{userId}")
    public ResponseEntity<List<UserAddressDTO>> getAddressesByUserId(@PathVariable UUID userId){
        return ResponseEntity.ok((addressServiceInterface.getAddressByUserId(userId)));
    }

    @DeleteMapping("deleteAddress/{addressId}")
    public void deleteRolesById(@PathVariable UUID addressId) {
        addressServiceInterface.deleteAddressById(addressId);
    }
}

