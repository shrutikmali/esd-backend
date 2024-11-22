package com.example.server.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "specialisations")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Specialisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialisation_id")
    private int specialisationId;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "credits_required", nullable = false)
    private int creditsRequired;

}
