package com.Proyecto_IS.Service;

import com.Proyecto_IS.Entidades.Carrito;
import com.Proyecto_IS.Entidades.Productos;
import com.Proyecto_IS.Repository.CarritoRepository;
import com.Proyecto_IS.Repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ProductosRepository productosRepository;

    public Carrito addProducto(Long idCarrito, Long idProducto){
        Carrito carrito = carritoRepository.findById(idCarrito).orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        Productos producto = productosRepository.findById(idProducto).orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        carrito.getProductos().add(producto);
        return carritoRepository.save(carrito);
    }
    public Carrito removeProducto(Long idCarrito, Long idProducto) {
        Carrito carrito = carritoRepository.findById(idCarrito).orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        Productos producto = productosRepository.findById(idProducto).orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        carrito.getProductos().remove(producto);
        return carritoRepository.save(carrito);
    }
    public Carrito obtenerCarrito(Long usuarioId){
        return carritoRepository.findByUsuarioId(usuarioId);
    }
}
