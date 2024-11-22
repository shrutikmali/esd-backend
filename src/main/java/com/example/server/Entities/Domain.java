package com.example.server.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "domain")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "domain_id")
    private int domainId;

    @Column(name = "program", nullable = false)
    private String program;

    @Column(name = "batch")
    private int batch;


    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "qualification")
    private String qualification;

}
