package com.Proyecto_IS.Controller;

import com.Proyecto_IS.Entidades.Orden;
import com.Proyecto_IS.Service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    @Autowired
    private OrdenService ordenService;

    @PostMapping
    public ResponseEntity<Orden> createOrden(@Validated @RequestBody Orden orden) {
        return ResponseEntity.ok(ordenService.createOrden(orden));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orden> getOrdenById(@PathVariable Long id) {
        return ResponseEntity.ok(ordenService.getOrdenById(id));
    }


}

