package com.internship.HRapp.dto.certificationDto;

import lombok.Data;

import java.net.URL;
import java.util.Date;
import java.util.UUID;

@Data
public class CertificationDto {
    private  UUID userId;
    private UUID certificationID;
    private String certificationName;
    private Date certificationYear;
    private Date expirationDate;
    private String releasingAuthority;
    private String linkOfCertification;
}