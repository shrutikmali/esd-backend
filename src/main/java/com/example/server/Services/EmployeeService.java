package com.example.server.Services;

import com.example.server.Entities.Department;
import com.example.server.Entities.Employee;
import com.example.server.Entities.Placement;
import com.example.server.Services.DepartmentService;
import com.example.server.Repositories.DepartmentRepository;
import com.example.server.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentService departmentService;

    public Employee fetchEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public Employee login(String email, String password) {
        Employee employee = this.fetchEmployeeByEmail(email);
        if(employee == null) {
            // Not found
            return null;
        }
        else {
            if(employee.getPassword().equals(password)) {
                // Login successful
                return employee;
            }
            else {
                // Invalid credentials
                return null;
            }
        }
    }

    public Employee createEmployee(
            String firstName,
            String lastName,
            String email,
            String password,
            String title,
            int deptId
    ) {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName(firstName);
        newEmployee.setLastName(lastName);
        newEmployee.setEmail(email);
        newEmployee.setPassword(password);
        newEmployee.setTitle(title);
        Department department = departmentService.findDepartmentById(deptId);
        newEmployee.setDepartment(department);

        return employeeRepository.save(newEmployee);

    }

}
