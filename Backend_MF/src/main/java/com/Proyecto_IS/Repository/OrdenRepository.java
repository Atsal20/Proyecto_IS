package com.Proyecto_IS.Repository;

import com.Proyecto_IS.Entidades.Orden;
import com.Proyecto_IS.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
    List<Orden> findByUsuarioId(Long usuarioId);
    List<Orden> findByEstado(String estado);
    List<Orden> findByUsuario(Usuario usuario);
}
