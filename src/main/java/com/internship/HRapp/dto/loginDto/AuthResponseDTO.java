package com.internship.HRapp.dto.loginDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthResponseDTO {
    private final String jwt;
    private final String refreshToken;
}
