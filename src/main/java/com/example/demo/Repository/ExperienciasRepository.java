package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Experiencias;

public interface ExperienciasRepository extends JpaRepository<Experiencias, Integer> {
    
}
