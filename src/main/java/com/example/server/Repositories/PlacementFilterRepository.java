package com.example.server.Repositories;

import com.example.server.Entities.PlacementFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacementFilterRepository extends JpaRepository<PlacementFilter, Integer> {

}
