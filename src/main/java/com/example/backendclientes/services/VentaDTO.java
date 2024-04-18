package com.example.backendclientes.services;

import com.example.backendclientes.model.Venta;

import java.util.Date;

public class VentaDTO {
    private Long id;
    private Long clienteId;
    private String clienteNombre; // Asumiendo que solo necesitas el nombre del cliente.
    private Date fechaVenta;
    private double total;

    public VentaDTO() {}

    // Constructor para simplificar la creación desde una entidad Venta
    public VentaDTO(Venta venta) {
        this.id = venta.getId();
        this.clienteId = venta.getCliente().getId();
        this.clienteNombre = venta.getCliente().getNombre(); // Asegúrate de que Cliente tiene un campo nombre
        this.fechaVenta = venta.getFechaVenta();
        this.total = venta.getTotal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
