package com.Proyecto_IS.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordenes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orden {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Date fecha;
        private String estado;
        private String direccion;
        private String ciudad;
        private String pais;
        private String codigoPostal;
        private Double total;

        @ManyToOne
        @JoinColumn(name = "usuario_id")
        private Usuario usuario;

        @ManyToMany
        @JoinTable(
            name = "ordenes_productos",
            joinColumns = @JoinColumn(name = "orden_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
        )
        private List<Productos> productos;
}
