package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.personalFileDto.PersonalFileDTO;
import com.internship.HRapp.entity.PersonalFile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonalFileMapper {
    @Mapping(source = "users.userId", target = "userId")
    PersonalFileDTO modeltoDto(PersonalFile personalFile);
    @Mapping(source = "userId", target = "users.userId")
    PersonalFile dtotoModel(PersonalFileDTO personalFileDto);

    List<PersonalFileDTO> toDto(List<PersonalFile> personalFiles);

    List<PersonalFile> toModel(List<PersonalFileDTO> personalFileDtos);
}