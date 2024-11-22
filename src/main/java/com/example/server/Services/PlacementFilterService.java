package com.example.server.Services;

import com.example.server.Entities.Domain;
import com.example.server.Entities.Placement;
import com.example.server.Entities.PlacementFilter;
import com.example.server.Entities.Specialisation;
import com.example.server.Repositories.PlacementFilterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacementFilterService {

    @Autowired
    PlacementFilterRepository placementFilterRepository;

    @Autowired
    DomainService domainService;

    @Autowired
    SpecialisationService specialisationService;

    @Autowired
    PlacementService placementService;

    public boolean savePlacementFilter(int placementId, List<Integer> specialisationIdList, List<Integer> domainIdList) {
        for(int specialisationId: specialisationIdList) {
            for(int domainId: domainIdList) {
                try {
                    Domain domain = domainService.getDomainById(domainId);
                    Specialisation specialisation = specialisationService.getSpecialisationById(specialisationId);
                    Placement placement = placementService.getPlacementById(placementId);

                    PlacementFilter placementFilter = new PlacementFilter();
                    placementFilter.setPlacement(placement);
                    placementFilter.setDomain(domain);
                    placementFilter.setSpecialisation(specialisation);

                    placementFilterRepository.save(placementFilter);
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                    return false;
                }

            }
        }

        return true;
    }

}
