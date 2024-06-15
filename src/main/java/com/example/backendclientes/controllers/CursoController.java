package com.example.backendclientes.controllers;

import com.example.backendclientes.model.Curso;
import com.example.backendclientes.services.CursoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoServiceImpl cursoService;
    @GetMapping
    public List<Object[]> getCursos(){
        return cursoService.getCursos();
    }
    @GetMapping("/nombre/{nombre}")
    public List<Object[]>  getCursoByNombre(@PathVariable String nombre) {
        return cursoService.findByNombre(nombre);
    }

    @GetMapping("/categorias")
    public List<String> listarCategorias() {
        return cursoService.findAllCategories();
    }

    @GetMapping("/estudiantes-por-categoria")
    public List<Object[]> countEstudiantesByCategoria() {
        return cursoService.countEstudiantesByCategoria();
    }
    @GetMapping("/conteo-por-categoria")
    public List<Map<String, Object>> countByCategoria(@RequestParam String categoria) {
        List<Object[]> estudiantes = cursoService.countEstudiantesByCategoria(categoria);
        List<Object[]> profesores = cursoService.countProfesoresByCategoria(categoria);

        return estudiantes.stream().map(estudiante -> {
            String cat = (String) estudiante[0];
            Long numEstudiantes = (Long) estudiante[1];
            Long numProfesores = profesores.stream()
                    .filter(profesor -> profesor[0].equals(cat))
                    .map(profesor -> (Long) profesor[1])
                    .findFirst().orElse(0L);
            Map<String, Object> result = new HashMap<>();
            result.put("categoria", cat);
            result.put("numEstudiantes", numEstudiantes);
            result.put("numProfesores", numProfesores);
            return result;
        }).collect(Collectors.toList());
    }
}
