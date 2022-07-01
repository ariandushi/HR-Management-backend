package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.skillDto.SkillDTO;
import com.internship.HRapp.entity.Skill;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    SkillDTO toDTO(Skill skill);

    List<SkillDTO> toDTOs(List<Skill> skills);

    Skill toEntity(SkillDTO skillDTO);

    List<Skill> toEntities(List<SkillDTO> skillDTOs);
}