package com.daw.parcelas.model;


import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;


@Entity(name = "parcela")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Parcela {

    //Autogeneramos el id que se ira incrementando de 1 en 1, no se repetira y sera unico por parcela
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Atributos de la clase Parcela, con sus validaciones y restricciones
    @NotBlank(message = "{parcela.nombre.obligatorio}")
    @Size(max = 60, message = "{parcela.nombre.longitud}")
    private String nombre;

    @NotBlank(message = "{parcela.ubicacion.obligatoria}")
    @Size(max = 80, message = "{parcela.ubicacion.longitud}")
    private String ubicacion;

    @NotNull(message = "{parcela.superficie.obligatoria}")
    @DecimalMin(value = "0.01", message = "{parcela.superficie.rango}")
    @DecimalMax(value = "5000", message = "{parcela.superficie.rango}")
    private Double superficie;

    @NotNull(message = "{parcela.tipoCultivo.obligatorio}")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "tipo_cultivo")
    private TipoCultivo tipoCultivo;



}
