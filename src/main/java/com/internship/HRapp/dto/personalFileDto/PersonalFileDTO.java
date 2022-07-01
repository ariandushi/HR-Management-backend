package com.internship.HRapp.dto.personalFileDto;

import lombok.Data;
import lombok.Getter;

import java.net.URL;
import java.util.UUID;

@Data
@Getter

public class PersonalFileDTO {
    private UUID userId;
    private UUID personalFileId;
    private URL idCard;
    private URL degree;
    private String workingSkills;
}