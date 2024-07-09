package com.example.gym.routine_recommendation_service.util;

import com.example.gym.routine_recommendation_service.model.Meta;
import com.example.gym.routine_recommendation_service.model.Persona;

public class RutinaUtil {

    public static float calculateIMC(Persona persona) {
        return persona.getPeso() / (persona.getAltura() * persona.getAltura());
    }

    public static Meta getMetaFromIMC(double imc) {
        if (imc < 18.5) {
            return Meta.SUBIR_PESO;
        } else if (imc >= 18.5 && imc < 24.9) {
            return Meta.MANTENER_PESO;
        } else {
            return Meta.BAJAR_PESO;
        }
    }
}
