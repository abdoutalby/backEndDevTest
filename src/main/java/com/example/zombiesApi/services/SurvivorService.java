package com.example.zombiesApi.services;

import com.example.zombiesApi.utils.Location;
import com.example.zombiesApi.models.Survivor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SurvivorService {
    ResponseEntity<Survivor> addSurvivor(Survivor survivor);
    ResponseEntity<?> updateLocation(Long SID, Location location);
    ResponseEntity<List<Survivor>> getAll();
    ResponseEntity<?> getReport();
}
