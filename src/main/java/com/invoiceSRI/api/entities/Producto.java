package com.invoiceSRI.api.entities;

import com.invoiceSRI.api.entities.enums.CodigoImpuestos;
import com.invoiceSRI.api.entities.enums.TarifaImpuestos;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;

import java.util.List;


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
    private CodigoImpuestos codigoImpuestos;

    @Column(name = "tarifa_iva")
    private TarifaImpuestos tarifaImpuestos;

    private int cantidad;

    @ManyToMany(mappedBy = "productos")
    private List<Factura> facturas;

    @ManyToMany(mappedBy = "productos")
    private List<Emisor> emisores;

    public Producto() {
    }

    public Producto(Long id, String nombre, String codigoPrincipal, String descripcion, double valorUnitario, double descuento, CodigoImpuestos codigoImpuestos, TarifaImpuestos tarifaImpuestos, int cantidad, List<Factura> facturas, List<Emisor> emisores) {
        this.id = id;
        this.nombre = nombre;
        this.codigoPrincipal = codigoPrincipal;
        this.descripcion = descripcion;
        this.valorUnitario = valorUnitario;
        this.descuento = descuento;
        this.codigoImpuestos = codigoImpuestos;
        this.tarifaImpuestos = tarifaImpuestos;
        this.cantidad = cantidad;
        this.facturas = facturas;
        this.emisores = emisores;
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

    public CodigoImpuestos getCodigoImpuestos() {
        return codigoImpuestos;
    }

    public void setCodigoImpuestos(CodigoImpuestos codigoImpuestos) {
        this.codigoImpuestos = codigoImpuestos;
    }

    public TarifaImpuestos getTarifaImpuestos() {
        return tarifaImpuestos;
    }

    public void setTarifaImpuestos(TarifaImpuestos tarifaImpuestos) {
        this.tarifaImpuestos = tarifaImpuestos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public List<Emisor> getEmisores() {
        return emisores;
    }

    public void setEmisores(List<Emisor> emisores) {
        this.emisores = emisores;
    }
}