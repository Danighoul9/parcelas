package com.daw.parcelas.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Producto producto;

    private Double cantidadKg;

    private LocalDate fechaRecoleccion;

    @Enumerated(EnumType.STRING)
    private Calidad calidad;
}