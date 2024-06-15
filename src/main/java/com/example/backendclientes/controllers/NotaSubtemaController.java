package com.example.backendclientes.controllers;

import com.example.backendclientes.services.NotaSubtemaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/notas_subtema")
public class NotaSubtemaController {
    @Autowired
    private NotaSubtemaServiceImpl notaSubtemaService;

    @GetMapping("/promedio")
    public List<Object[]> getPromedioNotasBySubtemaAndFecha(@RequestParam Long cursoId,
                                                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return notaSubtemaService.getPromedioNotasBySubtemaAndFecha(cursoId, startDate, endDate);
    }
}

