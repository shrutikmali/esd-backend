package com.example.server.Controllers;

import com.example.server.Entities.Specialisation;
import com.example.server.Services.SpecialisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/specialisation")
public class SpecialisationController {

    @Autowired
    SpecialisationService specialisationService;

    @GetMapping("/getall")
    ResponseEntity<HashMap<String, Object>> getAllSpecialisations() {
        HashMap<String, Object> response = new HashMap<>();
        try {
            List<Specialisation> specialisations = specialisationService.getAllSpecialisations();
            response.put("specialisations", specialisations);

            return ResponseEntity.ok().body(response);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            response.put("error", e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @PostMapping("/create")
    ResponseEntity<HashMap<String, Object>> createSpecialisation(@RequestBody HashMap<String, String> request) {
        String code = (String)request.get("code");
        String name = (String)request.get("name");
        String description = (String)request.get("description");
        int year = Integer.parseInt((String)request.get("year"));
        int creditsRequired = Integer.parseInt((String)request.get("creditsRequired"));

        HashMap<String, Object> response = new HashMap<>();
        try {
            Specialisation specialisation = specialisationService.addSpecialisation(code, name, description, year, creditsRequired);
            if(specialisation != null) {
                response.put("id", specialisation.getSpecialisationId());
                return ResponseEntity.ok().body(response);
            }
            else {
                throw new Exception("Error in creating specialisation");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            response.put("error", e.getMessage());

            return ResponseEntity.internalServerError().body(response);
        }
    }


}
