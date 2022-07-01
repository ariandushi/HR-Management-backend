package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.educationDto.EducationDto;
import com.internship.HRapp.entity.Education;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EducationMapper {
    @Mapping(source = "users.userId", target = "userId")
    EducationDto modeltoDto(Education education);

    @Mapping(source = "userId", target = "users.userId")
    Education dtotoModel(EducationDto educationDto);

    List<EducationDto> toDto(List<Education> educations);

    List<Education> toModel(List<EducationDto> educationDtos);
}