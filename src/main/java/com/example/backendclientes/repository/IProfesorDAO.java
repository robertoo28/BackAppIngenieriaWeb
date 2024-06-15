package com.example.backendclientes.repository;

import com.example.backendclientes.model.Profesor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProfesorDAO extends CrudRepository<Profesor,Long> {
    @Query(value = "SELECT p.nombre, p.apellido, p.horas_clase_mes " +
            "FROM cursos c " +
            "JOIN profesor_cursos pc ON c.nombre = pc.curso " +
            "JOIN profesores p ON pc.profesor_id = p.id " +
            "WHERE c.categoria = :categoria", nativeQuery = true)
    List<Object[]> profesorCategoria(@Param("categoria") String categoria);
}
