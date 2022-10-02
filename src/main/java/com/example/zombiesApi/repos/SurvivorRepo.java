package com.example.zombiesApi.repos;

import com.example.zombiesApi.models.Survivor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurvivorRepo extends JpaRepository<Survivor, Long > {
}

