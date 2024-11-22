package com.example.server.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DomainModel {

    private String program;
    private String qualification;
    private int capacity;
    private int batch;

}
