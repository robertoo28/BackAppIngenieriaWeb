package com.example.backendclientes.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "temas")
    public class Tema {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombre;

        @ManyToOne
        @JoinColumn(name = "curso_id")
        private Curso curso;

        @OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
        private List<Subtema> subtemas;

        private Float nota;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Subtema> getSubtemas() {
        return subtemas;
    }

    public void setSubtemas(List<Subtema> subtemas) {
        this.subtemas = subtemas;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }
}


