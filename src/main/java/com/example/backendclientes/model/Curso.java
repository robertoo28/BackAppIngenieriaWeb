package com.example.backendclientes.model;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;


    private String categoria;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EstudianteCurso> estudiantes;


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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<EstudianteCurso> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<EstudianteCurso> estudiantes) {
        this.estudiantes = estudiantes;
    }

    private static final long serialVersionUID = 1L;
}

