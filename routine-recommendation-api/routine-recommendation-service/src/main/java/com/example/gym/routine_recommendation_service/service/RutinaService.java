package com.example.gym.routine_recommendation_service.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.routine_recommendation_service.model.Ejercicio;
import com.example.gym.routine_recommendation_service.model.GrupoMuscular;
import com.example.gym.routine_recommendation_service.model.Meta;
import com.example.gym.routine_recommendation_service.model.Persona;
import com.example.gym.routine_recommendation_service.model.Rutina;
import com.example.gym.routine_recommendation_service.util.RutinaUtil;

@Service
public class RutinaService {

    @Autowired
    private EjercicioService ejercicioService;

    public List<Rutina> getRutinasRecomendadas(Persona persona) {
        float imc = RutinaUtil.calculateIMC(persona);
        Meta meta = RutinaUtil.getMetaFromIMC(imc);

        List<Rutina> rutinas = new ArrayList<>();
        for (GrupoMuscular grupoMuscular : GrupoMuscular.values()) {
            Rutina rutina = new Rutina(grupoMuscular.getValue(), meta.getValue());
            Duration duracionTotal = Duration.ZERO;

            List<Ejercicio> ejercicios = 
                ejercicioService.getEjerciciosByMetaAndGrupoMuscular
                (meta.getValue(), grupoMuscular.getValue());
            
            if (ejercicios.isEmpty()) {
                continue;
            }

            for (Ejercicio ejercicio : ejercicios) {
                duracionTotal = duracionTotal.plus(ejercicio.getDuracionTotal());
                    if (duracionTotal.toMinutes() >= Rutina.DURACION_MAXIMA) {
                        break;
                    }
                    rutina.setDuracion(ejercicio.getDuracionTotal());
                    rutina.getEjercicios().add(ejercicio);
            }
            rutinas.add(rutina);
        }
        return rutinas;
    }
}
