package com.example.gym.routine_recommendation_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.gym.routine_recommendation_service.model.Persona;
import com.example.gym.routine_recommendation_service.model.Rutina;
import com.example.gym.routine_recommendation_service.service.RutinaService;

@RestController
public class RutinaController {
    
    @Autowired
    private RutinaService rutinaService;

    @PostMapping("/rutinas/recomendadas")
    ResponseEntity<List<Rutina>> getRutinasRecomendadas(@RequestBody Persona persona)
    {
        List<Rutina> rutinas = rutinaService.getRutinasRecomendadas(persona);
        if (rutinas != null)
            return ResponseEntity.ok(rutinas);
        else
            return ResponseEntity.notFound().build();
    
    }
}
