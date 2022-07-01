package com.internship.HRapp.mapper;

import com.internship.HRapp.dto.dayOffDto.CreateDayOffDTO;
import com.internship.HRapp.dto.dayOffDto.StatusDTO;
import com.internship.HRapp.dto.dayOffDto.UserDayOffDTO;
import com.internship.HRapp.entity.DayOff;
import com.internship.HRapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DayOffMapper {
    UserDayOffDTO toDto(DayOff dayOff);

    @Mapping(source = "users.userId", target = "userId")
    StatusDTO statusToDTO(DayOff dayOff);

    @Mapping(source = "userId", target = "users.userId")
    DayOff statusToEntity(StatusDTO status);

    DayOff toModel(UserDayOffDTO userDayOffDTO);

    @Mapping(source = "userId", target = "users.userId")
    DayOff toEntity(CreateDayOffDTO requestDTO);

    @Mapping(source = "users.userId", target = "userId")
    CreateDayOffDTO requestToDto(DayOff dayOff);

    UserDayOffDTO userToDto(User user);

    User toUser(UserDayOffDTO userDayOffDTO);

    List<UserDayOffDTO> toDtos(List<DayOff> dayOffList);


}