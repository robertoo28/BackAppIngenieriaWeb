package com.example.backendclientes.services;

import com.example.backendclientes.model.Venta;
import com.example.backendclientes.repository.IVentaDAO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements IVentaService{
    @Autowired
    private IVentaDAO ventaDao;

    @Override
    @Transactional
    public Venta save(Venta venta) {
        return ventaDao.save(venta);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Venta> findAllByClienteId(Long clienteId) {
        return ventaDao.findByClienteId(clienteId);
    }
    public List<VentaDTO> findVentasByFechaVentaBetween(Date start, Date end) {
        List<Venta> ventas = ventaDao.findByFechaVentaBetween(start, end);
        return ventas.stream().map(VentaDTO::new).collect(Collectors.toList());
    }
}
