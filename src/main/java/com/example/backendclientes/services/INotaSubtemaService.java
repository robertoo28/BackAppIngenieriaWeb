package com.example.backendclientes.services;

import com.example.backendclientes.repository.INotaSubtemaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface INotaSubtemaService {
    public List<Object[]> getPromedioNotasBySubtemaAndFecha(Long cursoId, LocalDate startDate, LocalDate endDate);


}
