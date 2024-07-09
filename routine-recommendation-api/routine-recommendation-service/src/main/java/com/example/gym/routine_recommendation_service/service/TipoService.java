package com.example.gym.routine_recommendation_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.routine_recommendation_service.model.Categoria;
import com.example.gym.routine_recommendation_service.repository.TipoRepository;

@Service
public class TipoService {
    
    @Autowired
    private TipoRepository repository;

    public List<Categoria> getAllTipos() {
        return repository.findAll();
    }
}
