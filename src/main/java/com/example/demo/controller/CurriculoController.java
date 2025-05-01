package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.CurriculoService;
import com.example.demo.dto.Curriculodto;

import java.util.concurrent.ExecutionException;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/curriculo")
public class CurriculoController {

    @Autowired
    CurriculoService service;

    @PostMapping()
    public ResponseEntity postCurriculo(@RequestBody Curriculodto entity) {
        try{
            service.handleCreateNewCurriculo(entity);
            return ResponseEntity.ok().body(null);
        }
        catch(Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping()
    public ResponseEntity getCurriculo(@RequestParam Integer id) {
        try{
            var result = service.handleGetById(id);
            return ResponseEntity.ok().body(result);
        }
        catch(Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().body(null);
        }
    }
    
}
