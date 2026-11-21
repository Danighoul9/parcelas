package com.daw.parcelas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.*;


@Entity(name = "sensors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "{sensor.name.obligatorio}")
    @Size(max = 60, message = "{sensor.name.longitud}")
    private String name;

    @NotBlank(message = "{sensor.model.obligatorio}")
    @Size(max = 60, message = "{sensor.model.longitud}")
    private String model;

    @NotBlank(message = "{sensor.unidadMedida.obligatoria}")
    private String unidadMedida;

    @NotBlank(message = "{sensor.estado.obligatorio}")
    private String estado;

    @NotNull(message = "{sensor.tipo.obligatorio}")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "tipo_sensor")
    private TipoSensor tipo;

    @NotNull(message = "{sensor.latitud.obligatoria}")
    private Double latitud;

    @NotNull(message = "{sensor.longitud.obligatoria}")
    private Double longitud;


}