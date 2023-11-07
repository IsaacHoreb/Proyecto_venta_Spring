package com.pracitica.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "empleados")
public class EmpleadosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "name", length = 25, nullable = false, columnDefinition = "VARCHAR(25)")
    private String name;

    @NotBlank(message = "El apellido no puede estar en blanco")
    @Column(name = "last_name", length = 25, nullable = false, columnDefinition = "VARCHAR(25)")
    private String lastName;

    @NotBlank(message = "El telefono no puede estar en blanco")
    @Column(name = "phone", length = 19, nullable = false, columnDefinition = "VARCHAR(19)")
    private String phone;

    @Email
    @NotBlank(message = "El correo no puede estar en blanco")
    @Column(name = "email", length = 100, nullable = false, columnDefinition = "VARCHAR(100)")
    private String email;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El nombre del puesto no puede estar en blanco")
    @Column(name = "puesto", nullable = false, columnDefinition = "VARCHAR(25)")
    private EPuesto puesto; //Se relaciona con el archivo Enum

}
