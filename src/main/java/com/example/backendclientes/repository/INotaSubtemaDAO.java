package com.example.backendclientes.repository;

import com.example.backendclientes.model.Subtema;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface INotaSubtemaDAO extends CrudRepository<Subtema,Long> {

    @Query("SELECT st.nombre, AVG(ns.nota) AS promedioNota " +
            "FROM NotaSubtema ns " +
            "JOIN ns.subtema st " +
            "JOIN ns.estudianteCurso ec " +
            "JOIN ec.curso c " +
            "WHERE c.id = :cursoId AND ec.fechaInscripcion BETWEEN :startDate AND :endDate " +
            "GROUP BY st.nombre " +
            "ORDER BY promedioNota ASC")
    List<Object[]> findPromedioNotasBySubtemaAndFecha(@Param("cursoId") Long cursoId,
                                                      @Param("startDate") LocalDate startDate,
                                                      @Param("endDate") LocalDate endDate);
}
