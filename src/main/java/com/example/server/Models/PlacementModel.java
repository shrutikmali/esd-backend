package com.example.server.Models;

import com.example.server.Entities.Organisation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PlacementModel {

    private String profile;
    private String description;
    private int intake;
    Organisation organisation;

}
