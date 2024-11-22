package com.example.server.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "placement_filter")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PlacementFilter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "placement_id")
    Placement placement;

    @ManyToOne
    @JoinColumn(name = "specialisation_id")
    Specialisation specialisation;

    @ManyToOne
    @JoinColumn(name = "domain_id")
    Domain domain;

}
