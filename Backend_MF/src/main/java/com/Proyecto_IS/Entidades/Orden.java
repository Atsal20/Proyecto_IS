package com.Proyecto_IS.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

        @ManyToOne
        @JoinColumn(name = "usuario_id")
        private Usuario usuario;

        private Double total;

        @Temporal(TemporalType.TIMESTAMP)
        private Date fechaCreacion;

        private String estado;

       @OneToMany(mappedBy = "orden")
       private List<DetalleOrden> detalleOrden;
}
