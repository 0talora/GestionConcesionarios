package com.otalora.concesionario.controller;

import com.otalora.concesionario.model.Inventario;
import com.otalora.concesionario.service.inventario.InventarioService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventario")
@CrossOrigin(origins="*")
public class InventarioController {

    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping
    public List<Inventario> obtenerTodoInventario() {
        return inventarioService.obtenerTodoInventario();
    }

}
