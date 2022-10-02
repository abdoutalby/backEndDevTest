package com.example.zombiesApi.repos;

import com.example.zombiesApi.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepo extends JpaRepository<Property , Long> {
}
