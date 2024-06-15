package com.example.backendclientes.repository;

import com.example.backendclientes.model.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IClienteDAO extends CrudRepository<Cliente,Long> {


}
