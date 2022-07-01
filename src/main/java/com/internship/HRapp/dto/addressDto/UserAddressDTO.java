package com.internship.HRapp.dto.addressDto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class UserAddressDTO {
    private UUID userId;
    private UUID addressID;
    private String state;
    private String city;
    private String street;
    private String postalCode;
}
