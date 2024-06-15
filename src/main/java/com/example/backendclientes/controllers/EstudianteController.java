package com.example.backendclientes.controllers;

import com.example.backendclientes.model.Estudiante;
import com.example.backendclientes.services.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteServiceImpl estudianteService;
    @GetMapping("/count")
    public long contarEstudiantes() {
        return estudianteService.count();
    }
    @GetMapping("/promedio")
    public double promedio(@RequestParam String categoria){
        return estudianteService.findAverageNotaByCategoria(categoria);
    }
    @GetMapping("/Listestudiantes")
    public List<Object[]>estudiantes(@RequestParam String categoria){
        return estudianteService.findEstudiantesByCategoria(categoria);
    }
    @PostMapping("/save")
    public Estudiante guardarEstudiante(@RequestParam Estudiante estudiante){
        return estudianteService.save(estudiante);
    }

}
