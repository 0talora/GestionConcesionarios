package com.otalora.concesionario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "inventario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "modelo_id", nullable = false)
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "concesionario_id", nullable = false)
    private Concesionario concesionario;

    // Atributos simples
    private String color;

    @Column(name = "anio", nullable = false)
    private Integer anio;

    private Integer kilometraje;

    private Integer caballos;

    @Enumerated(EnumType.STRING)
    private Combustible combustible;

    private BigDecimal cubicaje;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(name = "duenos_previos", nullable = false)
    private Integer duenosPrevios;

    private String version;

    @Column(unique = true, nullable = false)
    private String matricula;

    @Column(name = "pais_origen", nullable = false)
    private String paisOrigen;

    @Column(name = "precio_compra", nullable = false)
    private BigDecimal precioCompra;

    @Column(name = "precio_venta", nullable = false)
    private BigDecimal precioVenta;

    // Enum para combustible
    public enum Combustible {
        Gasolina, Diésel, Eléctrico, Híbrido, GNC, GLP, Hidrógeno
    }

    // Enum para estado
    public enum Estado {
        Disponible, Reservado, Revisión, Vendido
    }

}
