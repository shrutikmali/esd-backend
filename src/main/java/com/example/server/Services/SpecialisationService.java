package com.example.server.Services;

import com.example.server.Entities.Specialisation;
import com.example.server.Repositories.SpecialisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialisationService {

    @Autowired
    private SpecialisationRepository specialisationRepository;

    public Specialisation getSpecialisationById(int specialisationId) {
        return specialisationRepository.findById(specialisationId);
    }

    public List<Specialisation> getAllSpecialisations() {
        return specialisationRepository.findAllBy();
    }

    public Specialisation addSpecialisation(String code, String name, String description, int year, int creditsRequired) {
        Specialisation specialisation = new Specialisation();
        specialisation.setCode(code);
        specialisation.setName(name);
        specialisation.setDescription(description);
        specialisation.setYear(year);
        specialisation.setCreditsRequired(creditsRequired);

        return specialisationRepository.save(specialisation);
    }

}
