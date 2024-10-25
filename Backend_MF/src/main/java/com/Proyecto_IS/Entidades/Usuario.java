package com.Proyecto_IS.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidos;
    private String email;
    private String password;
    private String rol;
    private String telefono;
    private String direccion;
    private String ciudad;
    private String codigoPostal;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @OneToMany(mappedBy = "usuario")
    private List<Orden> ordenes;
}

