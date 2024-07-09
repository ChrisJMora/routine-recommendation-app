package com.example.gym.routine_recommendation_service.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Meta {
    BAJAR_PESO("Bajar Peso"),
    MANTENER_PESO("Mantener Peso"),
    SUBIR_PESO("Subir Peso");

    private final String value;
}
