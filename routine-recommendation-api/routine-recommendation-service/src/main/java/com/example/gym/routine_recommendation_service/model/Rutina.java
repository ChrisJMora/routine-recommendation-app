package com.example.gym.routine_recommendation_service.model;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonPropertyOrder({"duracion_total", "grupo_muscular", "meta", "ejercicios"})
public class Rutina {

    public static final Integer DURACION_MAXIMA = 120;

    @JsonProperty("duracion_total")
    private Duration duracion;

    @JsonProperty("grupo_muscular")
    private String grupoMuscular;

    private String meta;

    private List<Ejercicio> ejercicios;

    public Rutina(String grupoMuscular, String meta) {
        this.duracion = Duration.ZERO;
        this.ejercicios = new ArrayList<>();
        this.grupoMuscular = grupoMuscular;
        this.meta = meta;
    }

    public void setDuracion(Duration duracion) {
        this.duracion = this.duracion.plus(duracion);
    }
}
