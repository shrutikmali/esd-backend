package com.example.server.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeeModel {

    private String firstName;
    private String lastName;
    private String email;
    private String title;
    private String department;

}
