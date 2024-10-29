package com.Proyecto_IS.Controller;

import com.Proyecto_IS.Entidades.Productos;
import com.Proyecto_IS.Service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productos")
public class ProductosController {
    @Autowired
    private ProductosService productosService;

    @GetMapping
    public Page<Productos> getAllProductos(Pageable pageable) {
        return productosService.getAllProductos(pageable);
    }

    @GetMapping("/search")
    public List<Productos> searchProductos(@RequestParam String nombre) {
        return productosService.searchProductos(nombre);
    }

    @GetMapping("/searchByCategory")
    public List<Productos> searchProductosByCategory(@RequestParam String nombre) {
        return productosService.searchProductosByCategory(nombre);
    }

    @GetMapping("/searchByPrecio")
    public List<Productos> searchProductosbyPrecio(@RequestParam Double precio) {
        return productosService.searchProductosbyPrecio(precio);
    }

    @GetMapping("/searchByCategoryAndPrecio")
    public List<Productos> searchProductosByCategoryAndPrecio(@RequestParam String nombre, Double precio) {
        return productosService.searchProductosByCategoryAndPrecio(nombre, precio);
    }

    @GetMapping("/getProductoById")
    public ResponseEntity<Productos> getProductoById(@PathVariable Long id) {
        return ResponseEntity.ok(productosService.getProductoById(id));
    }

    @PostMapping("/createProducto")
    public ResponseEntity<Productos> createProducto(@Validated @RequestBody Productos producto) {
        return ResponseEntity.ok(productosService.createProducto(producto));
    }

    @PostMapping("/saveProducto")
    public ResponseEntity<Productos> saveProducto(@Validated @RequestBody Productos producto) {
        return ResponseEntity.ok(productosService.saveProducto(producto));
    }

    @DeleteMapping("/deleteProducto")
    public ResponseEntity<Productos> deleteProducto(@PathVariable Long id) {
        productosService.deleteProducto(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateProducto")
    public ResponseEntity<Productos> updateProducto(@PathVariable Long id, @Validated @RequestBody Productos producto) {
        return ResponseEntity.ok(productosService.updateProducto(id, producto));
    }
}
