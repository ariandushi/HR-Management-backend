package com.internship.HRapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "userId")
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID userId;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private List<Role> roles = new ArrayList<>();
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "users_skills",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "skillId"))
    private List<Skill> skills = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

    @OneToMany(mappedBy = "users")
    private List<Certification> certifications = new ArrayList<>();

    @OneToMany(mappedBy = "users")
    private List<Education> educations = new ArrayList<>();

    @OneToMany(mappedBy = "users")
    private List<PersonalFile> personalFiles = new ArrayList<>();

    @ManyToMany(mappedBy = "users")
    private List<Projects> projects = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<Experiences> experiences = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private List<DayOff> daysOff = new ArrayList<>();

    @JsonIgnore
    @OneToOne(mappedBy = "users")
    private Address address;

    @Column(unique = true)
    private String username;
    private String password;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    private LocalDate dateOfBirth;
    private Double leaveDaysLeft;
    private String mobile;
    private LocalDate startingDay;
    private LocalDate terminationDay;
    private String secondContact;
    private Boolean usersStatus;

}