package com.example.server.Services;

import com.example.server.Entities.Organisation;
import com.example.server.Entities.Placement;
import com.example.server.Models.PlacementModel;
import com.example.server.Repositories.PlacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacementService {

    @Autowired
    private PlacementRepository placementRepository;

    @Autowired
    private OrganisationService organisationService;

    public List<Placement> getAllPlacement() {
        return placementRepository.findAll();
    }

    public Placement getPlacementById(int id) {
        return placementRepository.findById(id);
    }

    public Placement createPlacement(String profile, String description, int intake, int orgId, double minimumGrade) {
        Placement placement = new Placement();

        placement.setProfile(profile);
        placement.setDescription(description);
        placement.setIntake(intake);
        placement.setMinimumGrade(minimumGrade);
        Organisation organisation = organisationService.findOrganisationById(orgId);
        placement.setOrganisation(organisation);

        return placementRepository.save(placement);
    }

}
