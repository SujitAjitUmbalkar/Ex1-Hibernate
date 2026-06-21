package com.codingshuttle.springboot0To100.hospitalManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Appointment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)          // many appointments can have one doctor
    @JoinColumn(name = "doctor_id", nullable = false)
    @ToString.Exclude
    @JsonIgnore
    private Doctor doctor;
}

//LAZY fetch type means Hibernate loads only the foreign key initially
// and fetches the related entity from the database only when the getter is accessed

//We use @ToString.Exclude when we don't want related entities to be printed inside the current entity's
// toString() output, especially to avoid recursion and unnecessary data.
//used in printing

//@JsonIgnore from Jackson excludes the field during JSON serialization to prevent circular references,
// excessive nested output, and potential lazy loading exceptions when converting entities to API responses.
// used in return