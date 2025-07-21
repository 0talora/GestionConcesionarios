package com.otalora.concesionario.service.inventario;

import com.otalora.concesionario.model.Inventario;
import com.otalora.concesionario.repository.InventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioServiceImpl implements InventarioService {

    private final InventarioRepository inventarioRepository;

    public InventarioServiceImpl(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    @Override
    public List<Inventario> obtenerTodoInventario() {

        return inventarioRepository.findAll();

    }
}
