package com.Proyecto_IS.Service;

import com.Proyecto_IS.Entidades.Carrito;
import com.Proyecto_IS.Entidades.Orden;
import com.Proyecto_IS.Entidades.Productos;
import com.Proyecto_IS.Repository.CarritoRepository;
import com.Proyecto_IS.Repository.OrdenRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private CarritoRepository carritoRepository;

    public Orden crearOrden(Long carritoId) {
        Carrito carrito = carritoRepository.findById(carritoId).orElseThrow(() -> new RuntimeException("Carrito no encontrado"));

        Orden orden = new Orden();
        orden.setUsuario(carrito.getUsuario());
        orden.setFecha(new Date(Fecha));
        orden.setProductos(carrito.getProductos());
        orden.setTotal(carrito.getProductos().stream().mapToDouble(Productos::getPrecio).sum());

        // Vaciar el carrito después de crear la orden
        carrito.getProductos().clear();
        carritoRepository.save(carrito);

        return ordenRepository.save(orden);
    }

    public List<Orden> obtenerOrdenesPorUsuario(Long usuarioId) {
        return ordenRepository.findByUsuarioId(usuarioId);
    }
}
