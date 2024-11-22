package com.example.server.Repositories;

import com.example.server.Entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findById(int deptId);

}
