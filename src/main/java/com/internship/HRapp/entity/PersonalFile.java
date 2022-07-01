package com.internship.HRapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.net.URL;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")

    private UUID personalFileId;
    private URL idCard;
    private URL degree;
    private String workingSkills;

    @ManyToOne
    @JoinColumn(name = "user_personalFile_id", referencedColumnName = "userId")
    private User users;
}