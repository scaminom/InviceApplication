package com.invoiceSRI.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;


@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "codigo_principal")
    private String codigoPrincipal;

    private String descripcion;

    @Column(name = "valor_unitario")
    private double valorUnitario;

    private double descuento;

    @Column(name = "codigo_impuestos")
    private String codigoImpuestos;

    @Column(name = "tarifa_iva")
    private String tarifaImpuestos;

    private int cantidad;

    public Producto() {
    }

    public Producto(String nombre, String codigoPrincipal, String descripcion, double valorUnitario, double descuento, String codigoImpuestos, String tarifaImpuestos, int cantidad) {
        this.nombre = nombre;
        this.codigoPrincipal = codigoPrincipal;
        this.descripcion = descripcion;
        this.valorUnitario = valorUnitario;
        this.descuento = descuento;
        this.codigoImpuestos = codigoImpuestos;
        this.tarifaImpuestos = tarifaImpuestos;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoPrincipal() {
        return codigoPrincipal;
    }

    public void setCodigoPrincipal(String codigoPrincipal) {
        this.codigoPrincipal = codigoPrincipal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getCodigoImpuestos() {
        return codigoImpuestos;
    }

    public void setCodigoImpuestos(String codigoImpuestos) {
        this.codigoImpuestos = codigoImpuestos;
    }

    public String getTarifaImpuestos() {
        return tarifaImpuestos;
    }

    public void setTarifaImpuestos(String tarifaImpuestos) {
        this.tarifaImpuestos = tarifaImpuestos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}