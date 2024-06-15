package com.example.backendclientes.controllers;

import com.example.backendclientes.services.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    ProfesorServiceImpl profesorService;
    @GetMapping("/listado")
    List<Object[]> profesorCategoria(@RequestParam String categoria){
        return profesorService.profesorCategoria(categoria);
    }
}
