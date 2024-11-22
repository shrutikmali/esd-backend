package com.example.server.Repositories;

import com.example.server.Entities.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DomainRepository extends JpaRepository<Domain, Integer> {

    List<Domain> findAllBy();

    Domain findById(int id);
}
