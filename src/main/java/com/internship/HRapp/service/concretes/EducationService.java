package com.internship.HRapp.service.concretes;

import com.internship.HRapp.dto.educationDto.EducationDto;
import com.internship.HRapp.entity.Education;
import com.internship.HRapp.mapper.EducationMapper;
import com.internship.HRapp.repository.EducationRepository;
import com.internship.HRapp.repository.UserRepo;
import com.internship.HRapp.service.interfaces.EducationInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
@RequiredArgsConstructor
public class EducationService implements EducationInterface {
    private final EducationRepository educationRepository;
    private final EducationMapper educationMapper;
    private final UserRepo userRepo;

    @Override
    public EducationDto getEducationById(UUID educationId) {
        boolean exists = educationRepository.existsById(educationId);
        if (!exists) {
            throw new IllegalStateException(
                    "Education with id " + educationId + " does not exist!"
            );
        }
        return educationMapper.modeltoDto(educationRepository.getById(educationId));
    }

    @Override
    public List<EducationDto> getEducations() {
        return educationMapper.toDto(educationRepository.findAll());
    }

    @Override
    public EducationDto addNewEducation(EducationDto educationDto) {
        Education createdEducation = educationRepository.save(educationMapper.dtotoModel(educationDto));
        return educationMapper.modeltoDto(createdEducation);
    }

    @Override
    public void deleteEducationById(UUID educationId) {
        boolean exists = educationRepository.existsById(educationId);
        if (!exists) {
            throw new IllegalStateException(
                    "Education with id " + educationId + " does not exist!"
            );
        }
        educationRepository.deleteById(educationId);
    }

    @Override
    public List<EducationDto> getEducationByUserId(UUID userId) {
        boolean exists = userRepo.existsById(userId);
        if (!exists) {
            throw new IllegalStateException(
                    "User with id " + userId + " does not exist");
        }
        return educationMapper.toDto((educationRepository.getEducationByUsersUserId(userId)));
    }

    @Override
    public void editEducation(UUID educationId, EducationDto educationDto) {
        Education education = educationRepository.getById(educationId);
        education.setDegree(educationDto.getDegree());
        education.setUniversityName(educationDto.getUniversityName());
        education.setFacultyName(educationDto.getFacultyName());
        education.setStartTime(educationDto.getStartTime());
        educationRepository.save(education);
    }
}