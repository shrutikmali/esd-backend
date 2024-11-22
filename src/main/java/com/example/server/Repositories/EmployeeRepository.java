package com.example.server.Repositories;

import com.example.server.Entities.Employee;
import com.example.server.Entities.Placement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByEmail(String email);
}
