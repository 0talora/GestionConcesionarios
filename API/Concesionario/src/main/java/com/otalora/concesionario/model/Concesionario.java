package com.otalora.concesionario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="concesionario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Concesionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String calle;
    private int numero;
    private String ciudad;
    private String provincia;
    private int cp;
    private int telefono;

}