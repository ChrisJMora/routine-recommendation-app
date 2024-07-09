package com.example.gym.routine_recommendation_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gym.routine_recommendation_service.model.Ejercicio;

public interface EjercicioRepository extends JpaRepository<Ejercicio, Long> {
    List<Ejercicio> findByMeta(String meta);
    List<Ejercicio> findByGrupoMuscular(String grupoMuscular);
    List<Ejercicio> findByMetaAndGrupoMuscular(String meta, String grupoMuscular);
}
