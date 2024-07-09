package com.example.gym.routine_recommendation_service.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "tipo_ejercicio", schema = "rutinas")
public class TipoEjercicio {
    @EmbeddedId
    private TipoEjercicioId id;

    @ManyToOne
    @MapsId("ejercicioId")
    @JoinColumn(name = "ejercicio_id")
    private Ejercicio ejercicio;

    @ManyToOne
    @MapsId("tipoId")
    @JoinColumn(name = "tipo_id")
    private Categoria tipo;

    @Embeddable
    @EqualsAndHashCode
    public static class TipoEjercicioId implements Serializable {
        private Long ejercicioId;
        private Long tipoId;
    }
}
