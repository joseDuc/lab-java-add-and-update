package com.lab_java_add_and_update.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "admittedBy")
    private Employee admittedBy;
}
