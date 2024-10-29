package com.Proyecto_IS.Entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tallas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Talla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String talla;
}
