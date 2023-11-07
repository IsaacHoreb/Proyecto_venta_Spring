package com.pracitica.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "carros")
public class CarroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca", length = 15, nullable = false, columnDefinition = "VARCHAR(15)")
    private String marca;

    @Column(name = "modelo", length = 10, nullable = false, columnDefinition = "VARCHAR(10)")
    private String modelo;

    @Column(name = "color", length = 25, nullable = false, columnDefinition = "VARCHAR(25)")
    private String color;

    @Column(name = "placas", length = 15, nullable = false, columnDefinition = "VARCHAR(15)", unique = true)
    private String placas;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_ingreso", nullable = false, columnDefinition = "DATE")
    private LocalDate fechaIngreso;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_compra", nullable = false, columnDefinition = "DATE")
    private LocalDate fechaCompra;

    @Column(name = "precio", nullable = false, columnDefinition = "DOUBLE(10,2)")
    private Double precio;

    @Column(name = "status", nullable = false, columnDefinition = "VARCHAR(10)")
    private String status;

    @OneToMany(targetEntity = TablaRelacion.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "carro")
    private Set<TablaRelacion> carroComprador = new HashSet<>();

}
