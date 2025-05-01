package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
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
public class Experiencias {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
        
        @JsonIgnore
    @ManyToMany(mappedBy = "experiencias")
    private List<Curriculo> curriculos;
    String enterpriseName;
    String summary;
    LocalDateTime startTime;
    @Column(nullable = true)
    private LocalDateTime enDateTime;
}
