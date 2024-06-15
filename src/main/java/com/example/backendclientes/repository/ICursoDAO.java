package com.example.backendclientes.repository;

import com.example.backendclientes.model.Curso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICursoDAO extends CrudRepository<Curso,Long> {
    @Query("SELECT c.categoria, COUNT(ec) FROM Curso c JOIN c.estudiantes ec GROUP BY c.categoria")
    List<Object[]> countEstudiantesByCategoria();
    @Query("select c.categoria, c.nombre, c.id from Curso c ")
    List<Object[]> getcursos();


    @Query("SELECT c.nombre,c.categoria,c.id FROM Curso c WHERE c.nombre = :nombre")
    List<Object[]>  findByNombre(@Param("nombre") String nombre);



    @Query("SELECT c.categoria, COUNT(DISTINCT ec.estudiante.id) " +
            "FROM Curso c " +
            "LEFT JOIN c.estudiantes ec " +
            "WHERE c.categoria = :categoria " +
            "GROUP BY c.categoria")
    List<Object[]> countEstudiantesByCategoria(@Param("categoria") String categoria);

    @Query(value = "SELECT c.categoria, COUNT(DISTINCT p.id) " +
            "FROM cursos c " +
            "JOIN profesor_cursos pc ON c.nombre = pc.curso " +
            "JOIN profesores p ON pc.profesor_id = p.id " +
            "WHERE c.categoria = :categoria " +
            "GROUP BY c.categoria", nativeQuery = true)
    List<Object[]> countProfesoresByCategoria(@Param("categoria") String categoria);
}
