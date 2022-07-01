package com.internship.HRapp.service.interfaces;

import com.internship.HRapp.dto.userDto.UserCreateDTO;

import javax.mail.SendFailedException;

public interface UtilityInterface {

    void sendRegistrationEmail(UserCreateDTO userCreateDTO) throws Exception;

    String generateRandomPassword(int len);
}
