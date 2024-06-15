package com.example.backendclientes.services;

import com.example.backendclientes.model.Curso;

import java.util.List;
import java.util.Optional;

public interface ICursoService {
    Iterable<Curso> findAll();
    Optional<Curso> findById(Long id);
    Curso save(Curso curso);
    void deleteById(Long id);
    List<String> findAllCategories();
    List<Object[]> countEstudiantesByCategoria();
    List<Object[]> countEstudiantesByCategoria(String categoria);
    List<Object[]> countProfesoresByCategoria(String categoria);
    List<Object[]> getCursos();

    public List<Object[]>  findByNombre(String nombre);

}
