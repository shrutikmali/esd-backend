package com.example.server.Controllers;

import com.example.server.Entities.Domain;
import com.example.server.Services.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/domain")
public class DomainController {

    @Autowired
    DomainService domainService;

    @GetMapping("/getall")
    ResponseEntity<HashMap<String, Object>> getAllDomains() {
        try {
            List<Domain> domains = domainService.getAllDomains();
            HashMap<String, Object> response = new HashMap<>();
            response.put("domains", domains);
            return ResponseEntity.ok().body(response);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/create")
    ResponseEntity<HashMap<String, Object>> createDomain(@RequestBody HashMap<String, String> request) {
        String program = (String)request.get("program");
        int batch = Integer.parseInt((String)request.get("batch"));
        int capacity = Integer.parseInt((String)request.get("capacity"));
        String qualification = (String)request.get("qualification");

        try {
            Domain newDomain = domainService.createDomain(program, batch, capacity, qualification);
            if(newDomain != null) {
                HashMap<String, Object> response = new HashMap<>();
                response.put("id", newDomain.getDomainId());
                return ResponseEntity.ok().body(response);
            }
            else {
                throw new Exception("Error creating domain");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            HashMap<String, Object> response = new HashMap<>();
            response.put("error", e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

}
