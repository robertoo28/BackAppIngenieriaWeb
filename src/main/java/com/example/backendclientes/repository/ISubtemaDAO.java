package com.example.backendclientes.repository;

import com.example.backendclientes.model.Subtema;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ISubtemaDAO extends CrudRepository<Subtema, Long> {

    @Query("SELECT st.nombre, AVG(ec.nota) as avgNota " +
            "FROM Subtema st " +
            "JOIN st.tema t " +
            "JOIN t.curso c " +
            "JOIN EstudianteCurso ec ON ec.curso.id = c.id " +
            "WHERE ec.fechaInscripcion BETWEEN :startDate AND :endDate " +
            "GROUP BY st.id " +
            "ORDER BY avgNota ASC")
    List<Object[]> findAverageNotaBySubtemaInRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}

