package com.example.backendclientes.repository;

import com.example.backendclientes.model.Estudiante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEstudianteDAO extends CrudRepository <Estudiante, Long> {

    @Query("SELECT AVG(ec.nota) " +
            "FROM Curso c " +
            "JOIN c.estudiantes ec " +
            "WHERE c.categoria = :categoria")
    Double findAverageNotaByCategoria(@Param("categoria") String categoria);



    @Query("SELECT e.estudiante.nombre, e.estudiante.apellido, e.nota " +
            "FROM EstudianteCurso e JOIN e.curso c " +
            "WHERE c.categoria = :categoria")
    List<Object[]> findEstudiantesByCategoria(@Param("categoria") String categoria);

}
