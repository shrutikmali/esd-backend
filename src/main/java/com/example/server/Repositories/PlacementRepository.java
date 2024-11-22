package com.example.server.Repositories;

import com.example.server.Entities.Placement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacementRepository extends JpaRepository<Placement, Integer> {

    Placement findById(int id);

}
