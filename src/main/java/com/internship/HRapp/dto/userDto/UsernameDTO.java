package com.internship.HRapp.dto.userDto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UsernameDTO {
    @Column(unique = true)
    private String username;
}