package com.daw.parcelas.model;


import jakarta.persistence.*;
import lombok.*;


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

    private String nombre;
    private String ubicacion;
    private Double superficie;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "tipo_cultivo")
    private TipoCultivo tipo;



}
