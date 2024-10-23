package com.Proyecto_IS.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "usuario")
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
    private String pais;
    private String codigoPostal;
    private String dni;
    private String fechaNacimiento;
    private String fechaRegistro;
    private String fotoPerfil;

    @OneToMany(mappedBy = "usuario")
    private List<Orden> ordenes;
}

