package com.otalora.concesionario.controller;

import com.otalora.concesionario.model.Concesionario;
import com.otalora.concesionario.service.concesionario.ConcesionarioService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/concesionario")
@CrossOrigin(origins="*")
public class ConcesionarioController {

    private final ConcesionarioService concesionarioService;

    public ConcesionarioController(ConcesionarioService concesionarioService) {
        this.concesionarioService = concesionarioService;
    }

    @GetMapping
    public List<Concesionario> obtenerTodosConcesionarios() {
        return concesionarioService.obtenerTodosConcesionarios();
    }

}
