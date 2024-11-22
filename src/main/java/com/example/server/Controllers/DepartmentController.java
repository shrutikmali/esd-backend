package com.example.server.Controllers;

import com.example.server.Entities.Department;
import com.example.server.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/create")
    ResponseEntity<String> createDepartment(@RequestBody HashMap<String, Object> data) {
        String name = (String)data.get("name");
        int capacity = (int)data.get("capacity");

        try {
            Department department = departmentService.createDepartment(name, capacity);
            return ResponseEntity.ok("Department created");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body("Error creating department");
        }
    }

}
