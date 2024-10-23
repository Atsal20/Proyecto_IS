package com.Proyecto_IS.Controller;

import com.Proyecto_IS.Entidades.Productos;
import com.Proyecto_IS.Service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productos")
public class ProductosController {
    @Autowired
    private ProductosService productosService;

    @GetMapping
    public List<Productos> list() {
        return productosService.listAll();
    }
    @GetMapping("/{id}")
    public Productos get(@PathVariable Long id) {
        return productosService.get(id);
    }

    @PostMapping
    public Productos save(@RequestBody Productos producto) {
        return productosService.save(producto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productosService.delete(id);
    }

}
