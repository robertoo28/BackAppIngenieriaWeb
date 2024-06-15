package com.example.backendclientes.services;

import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProfesorService {
    List<Object[]> profesorCategoria(@Param("categoria") String categoria);
}
