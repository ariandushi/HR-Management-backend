package com.internship.HRapp.entity;

import com.internship.HRapp.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table
public class Task {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID taskId;
    @Column(nullable = false)
    private String taskName;
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus = TaskStatus.UNASSIGNED;
    private String description;

    @ManyToOne
    private User user;

    @ManyToOne
    private Projects project;


}
