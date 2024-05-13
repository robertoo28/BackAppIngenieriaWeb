package com.example.backendclientes.controllers;

import com.example.backendclientes.model.Cliente;
import com.example.backendclientes.model.Venta;
import com.example.backendclientes.repository.IClienteDAO;
import com.example.backendclientes.repository.IVentaDAO;
import com.example.backendclientes.services.IClienteService;
import com.example.backendclientes.services.IVentaService;
import com.example.backendclientes.services.VentaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin("*")
public class VentaRestController {
    @Autowired
    private IVentaService ventaService;

    @Autowired
    private IClienteService clienteService;

    @PostMapping("/registrar")
    public ResponseEntity<Venta> registrarVenta(@RequestBody Venta venta) {
        Cliente cliente = clienteService.findById(venta.getCliente().getId());
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        if(cliente.getNombre().length() > 20){
            return ResponseEntity.badRequest().build();
        }
        if (cliente.getApellido().length() >20) {
            return ResponseEntity.badRequest().build();
        }
        venta.setCliente(cliente);
        return ResponseEntity.ok(ventaService.save(venta));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Venta>> listarVentasPorCliente(@PathVariable Long clienteId) {
        List<Venta> ventas = ventaService.findAllByClienteId(clienteId);
        if (ventas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ventas);
    }
    @GetMapping("/por-fecha")
    public ResponseEntity<List<VentaDTO>> findVentasByDateRange(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {

        Date start = Date.from(fechaInicio.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date end = Date.from(fechaFin.atStartOfDay(ZoneId.systemDefault()).toInstant());
        List<VentaDTO> ventasDTO = ventaService.findVentasByFechaVentaBetween(start, end);
        return ResponseEntity.ok(ventasDTO);
    }
}
