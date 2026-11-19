package com.daw.parcelas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "sensors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String model;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "tipo_sensor")
    private TipoSensor tipo;

    @Column(name = "unidad_medida")
    private String unidadMedida;

    private String estado;

    @Column(nullable = true)
    private Double latitud;

    @Column(nullable = true)
    private Double longitud;



}