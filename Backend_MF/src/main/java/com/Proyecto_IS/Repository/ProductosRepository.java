package com.Proyecto_IS.Repository;

import com.Proyecto_IS.Entidades.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long> {
    List<Productos> findByNombre(String nombre);
    List<Productos> findByCategoriaNombre(String nombre);
    List<Productos> findByPrecio(Double precio);
    List<Productos> findByCategoriaNombreAndPrecio(String nombre, Double precio);
}
