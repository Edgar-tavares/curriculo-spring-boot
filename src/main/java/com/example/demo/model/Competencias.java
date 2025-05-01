package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Competencias {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "competencias")
    private List<Curriculo> curriculos;
    String title;
}
