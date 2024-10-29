package com.Proyecto_IS.Service;

import com.Proyecto_IS.Entidades.Productos;
import com.Proyecto_IS.Repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosService {
    @Autowired
    private ProductosRepository productosRepository;

    public Page<Productos> getAllProductos(Pageable pageable) {
        return productosRepository.findAll(pageable);
    }
    public List<Productos> searchProductos(String nombre) {
        return productosRepository.findByNombre(nombre);
    }
    public List<Productos> searchProductosByCategory(String nombre) {
        return productosRepository.findByCategoriaNombre(nombre);
    }
    public  List<Productos> searchProductosbyPrecio(Double precio) {
        return productosRepository.findByPrecio(precio);
    }
    public List<Productos> searchProductosByCategoryAndPrecio(String nombre, Double precio) {
        return productosRepository.findByCategoriaNombreAndPrecio(nombre, precio);
    }

    public Productos getProductoById(Long id) {
        return productosRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }
    public Productos createProducto(Productos producto) {
        return productosRepository.save(producto);
    }
    public Productos saveProducto(Productos producto) {
        return productosRepository.save(producto);
    }
    public void deleteProducto(Long id) {
        Productos producto = getProductoById(id);
        productosRepository.delete(producto);
    }
    public Productos updateProducto(Long id, Productos producto) {
        Productos productoActual = productosRepository.findById(id).get();
        productoActual.setNombre(producto.getNombre());
        productoActual.setDescripcion(producto.getDescripcion());
        productoActual.setPrecio(producto.getPrecio());
        productoActual.setImagenURL(producto.getImagenURL());
        productoActual.setStock(producto.getStock());
        productoActual.setCategoria(producto.getCategoria());
        return productosRepository.save(productoActual);
    }

}
