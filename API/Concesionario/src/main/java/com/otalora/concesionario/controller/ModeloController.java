package com.otalora.concesionario.controller;

import com.otalora.concesionario.model.Modelo;
import com.otalora.concesionario.service.modelo.ModeloService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/modelo")
@CrossOrigin(origins="*")

public class ModeloController {
    private final ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @GetMapping
    public List<Modelo> obtenerTodosModelos() {
        return modeloService.obtenerTodosModelos();
    }

}
