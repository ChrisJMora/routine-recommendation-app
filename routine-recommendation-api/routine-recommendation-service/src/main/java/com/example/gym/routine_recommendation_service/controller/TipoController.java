package com.example.gym.routine_recommendation_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gym.routine_recommendation_service.model.Categoria;
import com.example.gym.routine_recommendation_service.service.TipoService;

@RestController
public class TipoController {
    
    @Autowired
    private TipoService tipoService;

    @GetMapping("/tipos")
    ResponseEntity<List<Categoria>> getAllTipos() {
        List<Categoria> tipos = tipoService.getAllTipos();
        if (tipos != null)
            return ResponseEntity.ok(tipos);
        else
            return ResponseEntity.notFound().build();
    }
}
