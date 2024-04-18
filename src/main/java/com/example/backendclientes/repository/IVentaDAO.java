package com.example.backendclientes.repository;

import com.example.backendclientes.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IVentaDAO extends JpaRepository<Venta, Long> {
    List<Venta> findByClienteId(Long clienteId);
    List<Venta> findByFechaVentaBetween(Date fechaInicio, Date fechaFin);
}
