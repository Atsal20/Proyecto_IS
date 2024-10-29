package com.Proyecto_IS.Service;

import com.Proyecto_IS.Entidades.Orden;
import com.Proyecto_IS.Entidades.Usuario;
import com.Proyecto_IS.Repository.OrdenRepository;
import com.Proyecto_IS.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Orden createOrden(Orden orden) {
        orden.setFechaCreacion(new Date());
        orden.setEstado("Pendiente");
        return ordenRepository.save(orden);
    }

    public List<Orden> getOrdenesByUsuarioId(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return ordenRepository.findByUsuarioId(usuarioId);
    }

    public Orden getOrdenById(Long id) {
        return ordenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
    }

}
