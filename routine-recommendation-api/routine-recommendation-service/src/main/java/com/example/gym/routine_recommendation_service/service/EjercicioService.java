package com.example.gym.routine_recommendation_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.routine_recommendation_service.model.Ejercicio;
import com.example.gym.routine_recommendation_service.repository.EjercicioRepository;

@Service
public class EjercicioService {

    @Autowired
    private EjercicioRepository repository;

    public List<Ejercicio> getAllEjercicios() {
        return repository.findAll();
    }

    public List<Ejercicio> getEjerciciosByMeta(String meta) {
        return repository.findByMeta(meta);
    }

    public List<Ejercicio> getEjerciciosByGrupoMuscular(String grupoMuscular) {
        return repository.findByGrupoMuscular(grupoMuscular);
    }

    public List<Ejercicio> getEjerciciosByMetaAndGrupoMuscular(String meta, String grupoMuscular) {
        return repository.findByMetaAndGrupoMuscular(meta, grupoMuscular);
    }
}
