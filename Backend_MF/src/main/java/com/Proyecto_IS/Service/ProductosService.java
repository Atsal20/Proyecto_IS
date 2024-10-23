package com.Proyecto_IS.Service;

import com.Proyecto_IS.Entidades.Productos;
import com.Proyecto_IS.Repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosService {
    @Autowired
    private ProductosRepository productosRepository;

    public List<Productos> listAll() {
        return productosRepository.findAll();
    }

    public Productos get(Long id) {
        return productosRepository.findById(id).orElse(null);
    }
    public Productos save(Productos producto) {
        return productosRepository.save(producto);
    }
    public void delete(Long id) {
        productosRepository.deleteById(id);
    }
}
