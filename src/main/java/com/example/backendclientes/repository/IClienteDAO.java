package com.example.backendclientes.repository;

import com.example.backendclientes.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDAO extends CrudRepository<Cliente,Long> {
}
