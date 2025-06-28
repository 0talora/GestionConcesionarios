package com.otalora.concesionario.model;

import jakarta.persistence.*;

@Entity
@Table(name="concesionario")
public class Concesionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
