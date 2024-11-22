package com.example.server.Controllers;

import com.example.server.Services.PlacementFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/placementfilter")
public class PlacementFilterController {

    @Autowired
    PlacementFilterService placementFilterService;

    @PostMapping("/create")
    ResponseEntity<HashMap<String, Object>> createPlacementFilter(@RequestBody HashMap<String, Object> request) {

        HashMap<String, Object> response = new HashMap<>();
        System.out.println(request);
        int placementId = (int)request.get("placementId");
        List<Integer> domainIdList = (List<Integer>)request.get("domainIdList");
        List<Integer> specialisationIdList = (List<Integer>)request.get("specialisationIdList");

        try {
            boolean complete = placementFilterService.savePlacementFilter(placementId, specialisationIdList, domainIdList);
            if(!complete) {
                throw new Exception("Error in saving placement filter");
            }
            else {
                response.put("status", true);
                return ResponseEntity.ok(response);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            response.put("error", e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

}
