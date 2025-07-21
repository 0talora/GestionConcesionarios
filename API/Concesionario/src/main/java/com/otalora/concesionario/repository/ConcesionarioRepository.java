package com.otalora.concesionario.repository;

import com.otalora.concesionario.model.Concesionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcesionarioRepository extends JpaRepository<Concesionario,Long> {
}
