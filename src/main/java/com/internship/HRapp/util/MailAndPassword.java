package com.internship.HRapp.util;

import com.internship.HRapp.dto.userDto.UserCreateDTO;
import com.internship.HRapp.service.interfaces.UtilityInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.SendFailedException;
import java.security.SecureRandom;

@Service
@RequiredArgsConstructor
public class MailAndPassword implements UtilityInterface {
    private final JavaMailSender mailSender;

    @Override
    public String generateRandomPassword(int len) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
        return sb.toString();
    }

    @Override
    public void sendRegistrationEmail(UserCreateDTO userCreateDTO) throws SendFailedException {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(userCreateDTO.getEmail());
        email.setSubject("Welcome to 3i Solution," + userCreateDTO.getFirstName() + "!");
        email.setText(" Password for " + " '" + userCreateDTO.getUsername() + "' "
                + " is: " + userCreateDTO.getPassword());
        email.setFrom("naziibro33@yahoo.com");
        mailSender.send(email);
    }
}
