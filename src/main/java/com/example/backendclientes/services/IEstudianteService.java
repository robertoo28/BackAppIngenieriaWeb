package com.example.backendclientes.services;

import com.example.backendclientes.model.Estudiante;

import java.util.List;
import java.util.Optional;

public interface IEstudianteService {
    Iterable<Estudiante> findAll();
    Optional<Estudiante> findById(Long id);
    Estudiante save(Estudiante estudiante);
    Long count();
    void deleteById(Long id);
    Double findAverageNotaByCategoria(String categoria);
    List<Object[]> findEstudiantesByCategoria(String categoria);
}
