package com.Proyecto_IS.Controller;

import com.Proyecto_IS.Entidades.Orden;
import com.Proyecto_IS.Service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @PostMapping("/carrito/{carritoId}")
    public Orden crearOrden(@PathVariable Long carritoId) {
        return ordenService.crearOrden(carritoId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Orden> obtenerOrdenesPorUsuario(@PathVariable Long usuarioId) {
        return ordenService.obtenerOrdenesPorUsuario(usuarioId);
    }
}

