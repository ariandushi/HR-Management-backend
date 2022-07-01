package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.personalFileDto.PersonalFileDTO;

import java.util.List;
import java.util.UUID;

public interface PersonalFileInterface {
    List<PersonalFileDTO> getPersonalFiles();

    PersonalFileDTO addNewPersonalFile(PersonalFileDTO personalFileDto);

    PersonalFileDTO editPersonalFile(PersonalFileDTO personalFileDto);

    PersonalFileDTO getPersonalFileById(UUID personalFileId);

    void deletePersonalFileById(UUID personalFileId);

    List<PersonalFileDTO> getPersonalFileByUserId(UUID userId);
}