package com.Proyecto_IS.Entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalleOrden")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Productos producto;

    private Integer cantidad;
    private Double subtotal;


}
