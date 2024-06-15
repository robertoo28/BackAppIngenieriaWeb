package com.example.backendclientes.services;

import com.example.backendclientes.repository.IProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImpl implements IProfesorService{
    @Autowired
    IProfesorDAO profesorRepository;
    @Override
    public List<Object[]> profesorCategoria(String categoria) {
        return profesorRepository.profesorCategoria(categoria);
    }
}
