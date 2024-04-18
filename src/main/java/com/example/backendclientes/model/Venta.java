package com.example.backendclientes.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "ventas")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Venta {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "cliente_id", nullable = false)
        private Cliente cliente;

        @Column(nullable = false)
        private Date fechaVenta;

        @Column(nullable = false)
        private double total;

        // Constructor vacío
        public Venta() {
        }

        // Constructor con todos los campos
        public Venta(Cliente cliente, Date fechaVenta, double total) {
            this.cliente = cliente;
            this.fechaVenta = fechaVenta;
            this.total = total;
        }

        // Getters y setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
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


