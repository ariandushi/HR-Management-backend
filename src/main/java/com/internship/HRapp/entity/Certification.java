package com.internship.HRapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Certifications")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Certification {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "org.hibernate.type.PostgresUUIDType")

    private UUID certificationID;
    @Column(nullable = false)
    private String certificationName;
    private Date certificationYear;
    private Date expirationDate;
    private String releasingAuthority;
    private String linkOfCertification;

    @ManyToOne
    @JoinColumn(name = "user_certification_id", referencedColumnName = "userId")
    private User users;
}