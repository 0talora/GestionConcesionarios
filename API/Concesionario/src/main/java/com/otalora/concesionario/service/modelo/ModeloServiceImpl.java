package com.otalora.concesionario.service.modelo;

import com.otalora.concesionario.model.Modelo;
import com.otalora.concesionario.repository.ModeloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloServiceImpl implements ModeloService {

    private final ModeloRepository modeloRepository;

    public ModeloServiceImpl(ModeloRepository modeloRepository){
        this.modeloRepository=modeloRepository;
    }

    @Override
    public List<Modelo> obtenerTodosModelos() {
        return modeloRepository.findAll();
    }
}
