package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Curriculo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String fullName;
    String summary;
    @ManyToMany
    @JoinTable(
        name = "curriculo_competencia",
        joinColumns = @JoinColumn(name = "curriculo_id"),
        inverseJoinColumns = @JoinColumn(name = "competencia_id")
    )
    private List<Competencias> competencias = new ArrayList<>();
    @JsonManagedReference
    @ManyToMany
    @JoinTable(
        name = "curriculo_experiencia",
        joinColumns = @JoinColumn(name = "curriculo_id"),
        inverseJoinColumns = @JoinColumn(name = "experiencia_id")
    )
    private List<Experiencias> experiencias = new ArrayList<>();
}
