package com.example.server.Repositories;

import com.example.server.Entities.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganisationRepository extends JpaRepository<Organisation, Integer> {
    Organisation findById(int orgId);

    List<Organisation> findAllBy();

}
