package com.example.backendclientes.services;

import com.example.backendclientes.model.Cliente;
import com.example.backendclientes.model.Venta;

import java.util.Date;
import java.util.List;

public interface IVentaService {
    Venta save(Venta venta);
    List<Venta> findAllByClienteId(Long clienteId);
    public List<VentaDTO> findVentasByFechaVentaBetween(Date fechaInicio, Date fechaFin);
}
