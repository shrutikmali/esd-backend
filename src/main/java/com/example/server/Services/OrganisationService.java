package com.example.server.Services;

import com.example.server.Entities.Organisation;
import com.example.server.Repositories.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganisationService {

    @Autowired
    OrganisationRepository organisationRepository;

    public Organisation findOrganisationById(int orgId) {
        return organisationRepository.findById(orgId);
    }

    public Organisation createOrganisation(String name, String address) {
        Organisation newOrganisation = new Organisation();

        newOrganisation.setName(name);
        newOrganisation.setAddress(address);

        return organisationRepository.save(newOrganisation);
    }

    public List<Organisation> getAllOrganisations() {
        return organisationRepository.findAll();
    }
}
