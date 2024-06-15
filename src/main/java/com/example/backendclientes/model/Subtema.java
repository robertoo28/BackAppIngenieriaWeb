package com.example.backendclientes.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subtemas")
public class Subtema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "tema_id")
    private Tema tema;

    @OneToMany(mappedBy = "subtema")
    private List<NotaSubtema> notasSubtema;

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

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public List<NotaSubtema> getNotasSubtema() {
        return notasSubtema;
    }

    public void setNotasSubtema(List<NotaSubtema> notasSubtema) {
        this.notasSubtema = notasSubtema;
    }
}
