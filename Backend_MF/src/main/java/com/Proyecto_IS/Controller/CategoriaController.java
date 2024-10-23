package com.Proyecto_IS.Controller;

import com.Proyecto_IS.Entidades.Categoria;
import com.Proyecto_IS.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository CategoriaRepository;

    @GetMapping
    public List<Categoria> listAll() {
        return CategoriaRepository.findAll();
    }
    @PostMapping
    public Categoria save(@RequestBody Categoria categoria) {
        return CategoriaRepository.save(categoria);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        CategoriaRepository.deleteById(id);
    }
}
