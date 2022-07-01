package com.internship.HRapp.dto.userDto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PasswordDTO {
    private UUID userId;
    private CharSequence oldPassword;
    private String newPassword;
}
