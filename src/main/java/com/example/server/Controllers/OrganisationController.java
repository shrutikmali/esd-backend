package com.example.server.Controllers;

import com.example.server.Entities.Organisation;
import com.example.server.Services.OrganisationService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/organisation")
public class OrganisationController {

    @Autowired
    OrganisationService organisationService;

    @PostMapping("/create")
    ResponseEntity<HashMap<String, Object>> createOrganisation(@RequestBody HashMap<String, String> data) {
        String name = (String)data.get("name");
        String address = (String)data.get("address");
        try {
            Organisation organisation = organisationService.createOrganisation(name, address);
            HashMap<String, Object> response = new HashMap<>();
            response.put("orgId", (organisation.getId()));
            return ResponseEntity.ok().body(response);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/getall")
    ResponseEntity<HashMap<String, Object>> getOrganisations() {
        try {
            List<Organisation> organisationList = organisationService.getAllOrganisations();
            HashMap<String, Object> response = new HashMap<>();
            response.put("organisations", organisationList);

            return ResponseEntity.ok().body(response);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

}
