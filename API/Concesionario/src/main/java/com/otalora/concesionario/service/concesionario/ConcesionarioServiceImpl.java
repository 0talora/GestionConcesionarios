package com.otalora.concesionario.service.concesionario;

import com.otalora.concesionario.model.Concesionario;
import com.otalora.concesionario.repository.ConcesionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcesionarioServiceImpl implements ConcesionarioService {

    private final ConcesionarioRepository concesionarioRepository;

    public ConcesionarioServiceImpl(ConcesionarioRepository concesionarioRepository) {
        this.concesionarioRepository = concesionarioRepository;
    }

    @Override
    public List<Concesionario> obtenerTodosConcesionarios() {
        return concesionarioRepository.findAll();
    }

}
