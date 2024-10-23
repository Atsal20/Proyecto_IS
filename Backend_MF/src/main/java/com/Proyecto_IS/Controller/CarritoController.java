package com.Proyecto_IS.Controller;

import com.Proyecto_IS.Entidades.Carrito;
import com.Proyecto_IS.Service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carritos")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @PostMapping("/{carritoId}/productos/{productoId}")
    public Carrito addProdcuto(@PathVariable Long carritoId, @PathVariable Long productoId) {
        return carritoService.addProducto(carritoId, productoId);
    }

    @DeleteMapping("/{carritoId}/productos/{productoId}")
    public Carrito removeProducto(@PathVariable Long carritoId, @PathVariable Long productoId) {
        return carritoService.removeProducto(carritoId, productoId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public Carrito obtenerCarrito(@PathVariable Long usuarioId) {
        return carritoService.obtenerCarrito(usuarioId);
    }
}

