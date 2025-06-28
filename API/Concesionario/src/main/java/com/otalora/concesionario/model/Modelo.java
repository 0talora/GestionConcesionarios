package com.otalora.concesionario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="modelo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String marca;

    private int puertas;
    @Column(name = "anio_lanzamiento", nullable = false)
    private int anioLanzamiento;

    @Column(name = "anio_cese")
    private Integer anioCese;

}
