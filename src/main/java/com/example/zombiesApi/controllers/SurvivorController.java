package com.example.zombiesApi.controllers;

import com.example.zombiesApi.models.Survivor;
import com.example.zombiesApi.services.SurvivorServiceImp;
import com.example.zombiesApi.utils.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/survivors/")
public class SurvivorController {

    @Autowired
    SurvivorServiceImp survivorService ;

    @PostMapping()
    public ResponseEntity<Survivor> save(@RequestBody Survivor body){
        return survivorService.addSurvivor(body);
    }

    @PutMapping("location/{SID}")
    public ResponseEntity<?> updateLocation(@PathVariable("SID") Long sid , @RequestBody Location location){
        return survivorService.updateLocation(sid, location);

    }

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return survivorService.getAll();
    }

    @GetMapping("report")
    public ResponseEntity<?> getReport(){
        return survivorService.getReport();
    }

}
