package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.projectsDto.ProjectsDTO;
import com.internship.HRapp.dto.userDto.AssignUserDTO;
import com.internship.HRapp.entity.Projects;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectsMapper {
    ProjectsDTO entityToDto(Projects projects);

    List<ProjectsDTO> entitiesToDtos(List<Projects> theProjects);

    List<ProjectsDTO> entitiesToDtosProjects(List<Projects> theProjects);

    Projects dtoToEntity(ProjectsDTO projectsDTO);

    List<Projects> toEntities(List<ProjectsDTO> projectsDTOS);

    AssignUserDTO toDTOAssignUser(Projects project);

    List<AssignUserDTO> toDTOsAssignUser(List<Projects> projects);

    Projects toEntityAssignUser(AssignUserDTO assignUserDTO);

    List<Projects> toEntitiesAssignUser(List<AssignUserDTO> assignUserDTOs);

}