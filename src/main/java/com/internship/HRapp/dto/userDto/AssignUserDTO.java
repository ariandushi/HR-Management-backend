package com.internship.HRapp.dto.userDto;

import lombok.Data;

import java.util.List;

@Data
public class AssignUserDTO {
    private List<GetUsersDTO> users;
}