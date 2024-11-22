package com.example.server.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "placement")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Placement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "profile", nullable = false)
    private String profile;

    @Column(name = "description")
    private String description;

    @Column(name = "intake", nullable = false)
    private int intake;

    @Column(name = "minimum_grade")
    private double minimumGrade;

    @ManyToOne
    @JoinColumn(name = "org_id")
    Organisation organisation;

}
