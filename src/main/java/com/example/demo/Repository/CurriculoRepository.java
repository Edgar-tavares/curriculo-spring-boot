package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Curriculo;

public interface CurriculoRepository extends JpaRepository<Curriculo, Integer> {   
}
