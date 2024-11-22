package com.example.server.Services;

import com.example.server.Entities.Department;
import com.example.server.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public Department findDepartmentById(int deptId) {
        return departmentRepository.findById(deptId);
    }

    public Department createDepartment(String name, int capacity) {
        Department department = new Department();
        department.setName(name);
        department.setCapacity(capacity);
        return departmentRepository.save(department);
    }

}
