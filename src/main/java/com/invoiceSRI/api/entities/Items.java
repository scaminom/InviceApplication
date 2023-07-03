package com.invoiceSRI.api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    @JsonBackReference
    private Factura factura;

    private double descuento;

    private double total;

    public Items() {
    }

    public Items(Producto producto, int cantidad, double descuento, double total) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.total = total;
        this.factura = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}