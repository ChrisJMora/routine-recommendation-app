package com.example.gym.routine_recommendation_service.model;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "ejercicio", schema = "rutinas")
@JsonPropertyOrder({"nombre", "descripcion", "series", "repeticiones", "duracion_por_repeticion", "descanso_entre_series", "categorias"})
public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ejercicio_id")
    @JsonIgnore
    private Long id;

    private String nombre;

    private String descripcion;

    private Integer series;

    private Integer repeticiones;

    @JsonProperty("duracion_por_repeticion")
    private Time duracion;

    @JsonProperty("descanso_entre_series")
    private Time descanso;

    @Column(name = "grupo_muscular")
    @JsonIgnore
    private String grupoMuscular;

    @JsonIgnore
    private String meta;

    @ManyToMany
    @JoinTable(
        name = "tipo_ejercicio",
        schema = "rutinas",
        joinColumns = @JoinColumn(name = "ejercicio_id"),
        inverseJoinColumns = @JoinColumn(name = "tipo_id")
    )
    private Set<Categoria> categorias;

    public Duration getDuracion()
    {
        LocalTime localTime = duracion.toLocalTime();
        return Duration.ofHours(localTime.getHour())
        .plusMinutes(localTime.getMinute())
        .plusSeconds(localTime.getSecond());
    }

    public Duration getDescanso()
    {
        LocalTime localTime = descanso.toLocalTime();
        return Duration.ofHours(localTime.getHour())
        .plusMinutes(localTime.getMinute())
        .plusSeconds(localTime.getSecond());
    }

    @JsonProperty("duracion_total")
    public Duration getDuracionTotal() {
        return ((getDuracion().multipliedBy(repeticiones))
        .plus(getDescanso())).multipliedBy(series);
    }
}
