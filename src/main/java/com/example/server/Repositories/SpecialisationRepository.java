package com.example.server.Repositories;

import com.example.server.Entities.Specialisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialisationRepository extends JpaRepository<Specialisation, Integer> {

    List<Specialisation> findAllBy();

    Specialisation findById(int id);

}
