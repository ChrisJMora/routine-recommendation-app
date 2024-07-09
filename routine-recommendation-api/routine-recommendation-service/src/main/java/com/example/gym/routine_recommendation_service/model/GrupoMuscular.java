package com.example.gym.routine_recommendation_service.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GrupoMuscular {
    PARTE_SUPERIOR("Parte Superior"),
    PARTE_MEDIA("Parte Media"),
    PARTE_INFERIOR("Parte Inferior"),
    CUERPO_COMPLETO("Todo el Cuerpo");

    private final String value;
}
