package com.example.backendclientes.services;

import com.example.backendclientes.model.Curso;
import com.example.backendclientes.repository.ICursoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CursoServiceImpl implements ICursoService {
    @Autowired
    private ICursoDAO cursoRepository;

    @Override
    public Iterable<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }
    @Override
    public List<String> findAllCategories() {
        return StreamSupport.stream(cursoRepository.findAll().spliterator(), false)
                .map(Curso::getCategoria)
                .distinct()
                .collect(Collectors.toList());
    }
    @Override
    public List<Object[]> countEstudiantesByCategoria() {
        return cursoRepository.countEstudiantesByCategoria();
    }

    @Override
    public List<Object[]> countEstudiantesByCategoria(String categoria) {
        return cursoRepository.countEstudiantesByCategoria(categoria);
    }

    @Override
    public List<Object[]> countProfesoresByCategoria(String categoria) {
        return cursoRepository.countProfesoresByCategoria(categoria);
    }
    @Override
    public List<Object[]> getCursos(){
        return cursoRepository.getcursos();
    }
    public List<Object[]> findByNombre(String nombre) {
        return cursoRepository.findByNombre(nombre);
    }

}
