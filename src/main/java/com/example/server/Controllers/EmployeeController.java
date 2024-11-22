package com.example.server.Controllers;


import com.example.server.Entities.Employee;
import com.example.server.Entities.Organisation;
import com.example.server.Services.DepartmentService;
import com.example.server.Models.EmployeeModel;
import com.example.server.Services.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/login")
    public ResponseEntity<HashMap<String, String>> loginEmployee(@RequestBody HashMap<String, Object> request) {
        String email = (String)request.get("email");
        String password = (String)request.get("password");
        HashMap<String, String> response = new HashMap<>();

        try {
            Employee employee = employeeService.login(email, password);
            if(employee != null) {
                response.put("id", Integer.toString(employee.getEmployeeId()));
                response.put("name", employee.getFirstName());
                response.put("dept", Integer.toString(employee.getDepartment().getDepartmentId()));
                response.put("status", "200");
                return ResponseEntity.ok().body(response);
            }
            else {
                response.put("status", "404");
                response.put("information", "Invalid credentials");
                return ResponseEntity.ok(response);
            }
        }
        catch (Exception e) {
            System.out.println("Error logging in employee: " + e.getMessage());
            response.put("information", e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody HashMap<String, Object> data) {
        String firstName = (String)data.get("firstName");
        String lastName = (String)data.getOrDefault("lastName", null);
        String email = (String)data.get("email");
        String password = (String)data.get("password");
        String title = (String)data.getOrDefault("title", null);
        int deptId = (int)data.get("deptId");
        try {
            Employee newEmployee = employeeService.createEmployee(firstName, lastName, email, password, title, deptId);
            return ResponseEntity.status(200).build();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok().body("Hello from employee");
    }

}
