package com.example.gym.routine_recommendation_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gym.routine_recommendation_service.model.Categoria;

public interface TipoRepository extends JpaRepository<Categoria, Long>{
    
}
