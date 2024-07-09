package com.example.gym.routine_recommendation_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gym.routine_recommendation_service.model.Ejercicio;
import com.example.gym.routine_recommendation_service.service.EjercicioService;

@RestController
public class EjercicioController {
    
    @Autowired
    private EjercicioService ejercicioService;

    @GetMapping("/ejercicios")
    ResponseEntity<List<Ejercicio>> getAllEjercicios() {
        List<Ejercicio> ejercicios = ejercicioService.getAllEjercicios();
        if (ejercicios != null)
            return ResponseEntity.ok(ejercicios);
        else
            return ResponseEntity.notFound().build();
    }
}
