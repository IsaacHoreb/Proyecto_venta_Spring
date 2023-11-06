package com.pracitica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "compradores")
public class CompradorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 25, nullable = false, columnDefinition = "VARCHAR(25)")
    private String name;

    @Column(name = "last_name", length = 25, nullable = false, columnDefinition = "VARCHAR(25)")
    private String lastName;

    @Column(name = "age", length = 11, nullable = false, columnDefinition = "INT(11)")
    private Integer age;

    @Column(name = "phone", length = 18, nullable = false, columnDefinition = "VARCHAR(17)")
    private String phone;

    @OneToMany(targetEntity = TablaRelacion.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "comprador")
    private Set<TablaRelacion> carroComprador = new HashSet<>();


    /*
    @Column(name = "vehiculo_comp")
    private Long vehiculoMone;

    @ManyToOne(targetEntity = CarroEntity.class, fetch = FetchType.LAZY)
    @JoinTable(name = "vehiculos_coprado", joinColumns = @JoinColumn(name = "comprador_id"), inverseJoinColumns = @JoinColumn(name = "carro_id"))
    private CarroEntity vehiculoComp;
    */

}
