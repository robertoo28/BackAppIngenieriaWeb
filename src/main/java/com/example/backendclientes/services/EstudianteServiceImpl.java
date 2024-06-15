package com.example.backendclientes.services;

import com.example.backendclientes.model.Estudiante;
import com.example.backendclientes.repository.IEstudianteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements IEstudianteService{
    @Autowired
    private IEstudianteDAO estudianteRepository;

    @Override
    public Iterable<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    @Override
    public Optional<Estudiante> findById(Long id) {
        return estudianteRepository.findById(id);
    }

    @Override
    public Estudiante save(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Long count() {
        return estudianteRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        estudianteRepository.deleteById(id);
    }

    @Override
    public Double findAverageNotaByCategoria(String categoria) {
        return estudianteRepository.findAverageNotaByCategoria(categoria);
    }

    @Override
    public List<Object[]> findEstudiantesByCategoria(String categoria) {
        return estudianteRepository.findEstudiantesByCategoria(categoria);
    }
}
