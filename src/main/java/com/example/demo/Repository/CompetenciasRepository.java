package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Competencias;

public interface CompetenciasRepository extends JpaRepository<Competencias, Integer> {
    
}
