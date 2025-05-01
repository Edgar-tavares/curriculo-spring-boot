package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CompetenciasRepository;
import com.example.demo.Repository.CurriculoRepository;
import com.example.demo.Repository.ExperienciasRepository;
import com.example.demo.dto.Curriculodto;
import com.example.demo.dto.Experienciasdto;
import com.example.demo.model.Competencias;
import com.example.demo.model.Curriculo;
import com.example.demo.model.Experiencias;

@Service
public class CurriculoService {
    @Autowired
    CurriculoRepository curriculoRepository;
    @Autowired
    ExperienciasRepository experienciaRepository;
    @Autowired
    CompetenciasRepository competenciasRepository;
    
    public void handleCreateNewCurriculo(Curriculodto dto){
        List<Experiencias> experiencias = new ArrayList<>();
        List<Competencias> competencias = new ArrayList<>();
        Curriculo curriculo = new Curriculo();
        for(Experienciasdto element : dto.experiencias()){
            Experiencias experiencia = new Experiencias();
            experiencia.setStartTime(element.start());
            experiencia.setEnDateTime(element.end());
            experiencia.setEnterpriseName(element.enterprise());
            experiencia.setSummary(element.summary());
            experiencias.add(experiencia);
        }
        for(String element : dto.competencias()){
            Competencias competencia = new Competencias();
            competencia.setTitle(element);
            competencias.add(competencia);
        }
        competenciasRepository.saveAll(competencias);
        experienciaRepository.saveAll(experiencias);

        curriculo.setFullName(dto.name());
        curriculo.setSummary(dto.summary());
        curriculo.setCompetencias(competencias);
        curriculo.setExperiencias(experiencias);

        curriculoRepository.save(curriculo);
    }

    public Optional<Curriculo> handleGetById(Integer id){
        return curriculoRepository.findById(id);
    }
}
