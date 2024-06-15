package com.example.backendclientes.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "notas_subtema")
public class NotaSubtema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double nota;

    @ManyToOne
    @JoinColumn(name = "subtema_id")
    private Subtema subtema;

    @ManyToOne
    @JoinColumn(name = "estudiante_curso_id")
    private EstudianteCurso estudianteCurso;

    // Getters y Setters
}


