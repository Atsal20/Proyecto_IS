package com.Proyecto_IS.Controller;

import com.Proyecto_IS.Entidades.Talla;
import com.Proyecto_IS.Repository.TallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/talla")
public class TallaController {
    @Autowired
    private TallaRepository TallaRepository;

    @GetMapping
    public List<Talla> listAll() {
        return TallaRepository.findAll();
    }
    @PostMapping
    public Talla save(@RequestBody Talla talla) {
        return TallaRepository.save(talla);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        TallaRepository.deleteById(id);
    }
}
