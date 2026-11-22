package com.daw.parcelas.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @NotNull(message = "{produccion.producto.obligatorio}")
    @Column(nullable = false)
    private Producto producto;

    @NotNull(message = "{produccion.cantidad.obligatoria}")
    @Positive(message = "{produccion.cantidad.positiva}")
    @DecimalMax(value = "1000000.0", message = "{produccion.cantidad.maxima}")
    private Double cantidadKg;

    @NotNull(message = "{produccion.fecha.obligatoria}")
    @PastOrPresent(message = "{produccion.fecha.futura}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaRecoleccion;

    @NotNull(message = "{produccion.calidad.obligatoria}")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Calidad calidad;
}
