package com.example.server.Controllers;

import com.example.server.Entities.Placement;
import com.example.server.Services.PlacementService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/placement")
public class PlacementController {

    @Autowired
    PlacementService placementService;

    @GetMapping("/getall")
    public ResponseEntity<HashMap<String, Object>> getAllPlacements() {
        HashMap<String, Object> response = new HashMap<>();
        try {
            List<Placement> placementList = placementService.getAllPlacement();
            response.put("placements", placementList);

            return ResponseEntity.ok(response);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            response.put("error", e.getMessage());

            return ResponseEntity.internalServerError().body(response);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<HashMap<String, Object>> createPlacement(@RequestBody HashMap<String, Object> request) {
        HashMap<String, Object> response = new HashMap<>();

        int deptId = (int)request.get("deptId");
        int orgId = (int)request.get("orgId");
        String profile = (String)request.get("profile");
        String description = (String)request.get("description");
        int intake = (int)request.get("intake");
        double minimumGrade = (double)request.get("minimumGrade");

        try {
            if(deptId != 2) {
                throw new Exception("Not allowed");
            }
            else {
                Placement placement = placementService.createPlacement(profile, description, intake, orgId, minimumGrade);

                if(placement != null) {
                    response.put("placementId", placement.getId());
                    return ResponseEntity.ok(response);
                }
                else {
                    throw new Exception("Error in creating placement");
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            response.put("error", e.getMessage());

            return ResponseEntity.internalServerError().body(response);
        }
    }

}
