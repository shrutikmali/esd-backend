package com.example.server.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SpecialisationModel {

    private String code;
    private String name;
    private String description;
    private int year;
    private int creditsRequired;

}
