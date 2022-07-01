package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.certificationDto.CertificationDto;
import com.internship.HRapp.entity.Certification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CertificationMapper {
    @Mapping(source = "users.userId", target = "userId")
    CertificationDto modeltoDto(Certification certification);

    @Mapping(source = "userId", target = "users.userId")
    Certification dtotoModel(CertificationDto certificationDto);

    List<CertificationDto> toDto(List<Certification> certifications);

    List<Certification> toModel(List<CertificationDto> certificationDtos);

}