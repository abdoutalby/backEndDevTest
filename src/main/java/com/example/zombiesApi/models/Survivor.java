package com.example.zombiesApi.models;


import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Survivor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name;

    private int age ;

    private String gender;

    private double latitude;

    private double longitude;

    private Boolean infected ;

    @OneToMany
    private Set<Property> resources =  new HashSet<>();

}
