package com.invoiceSRI.api.entities;

import com.invoiceSRI.api.entities.enums.Ambiente;
import com.invoiceSRI.api.entities.enums.ObligadoContabilidad;
import com.invoiceSRI.api.entities.enums.TipoEmision;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "emisor")
public class Emisor {
    @Id
    @Column(name = "ruc")
    private String ruc;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "nombre_comercial")
    private String nombreComercial;

    @Column(name = "direccion_matriz")
    private String direccionMatriz;

    @Column(name = "obligado_contabilidad")
    @Enumerated(EnumType.ORDINAL)
    private ObligadoContabilidad obligadoContabilidad;

    @Column(name = "codigo_establecimiento")
    private String codigoEstablecimiento;

    @Column(name = "codigo_punto_emision")
    private String codigoPuntoEmision;

    @Column(name = "tiempo_maximo_espera_respuesta_autorizacion")
    private int tiempoMaximoEsperaRespuestaAutorizacion;

    @Column(name = "tipo_ambiente")
    @Enumerated(EnumType.ORDINAL)
    private Ambiente tipoAmbiente;

    @Column(name = "tipo_emision")
    @Enumerated(EnumType.ORDINAL)
    private TipoEmision tipoEmision;

    //Tengo que revisar muy bien sobre los tokens
    @Column(name = "token_firmar")
    private String tokenFirmar;

    @OneToMany(mappedBy = "emisor")
    private List<Factura> facturas;

    @ManyToMany
    @JoinTable(name = "emisor_producto",
            joinColumns = @JoinColumn(name = "emisor_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id"))
    private List<Producto> productos;

    @ManyToOne
    @JoinColumn(name = "establecimiento_id")
    private Establecimiento establecimiento;

    public Emisor() {
    }

    public Emisor(String ruc, String razonSocial, String nombreComercial, String direccionMatriz, ObligadoContabilidad obligadoContabilidad, String codigoEstablecimiento, String codigoPuntoEmision, int tiempoMaximoEsperaRespuestaAutorizacion, Ambiente tipoAmbiente, TipoEmision tipoEmision, String tokenFirmar, List<Factura> facturas, List<Producto> productos, Establecimiento establecimiento) {
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.nombreComercial = nombreComercial;
        this.direccionMatriz = direccionMatriz;
        this.obligadoContabilidad = obligadoContabilidad;
        this.codigoEstablecimiento = codigoEstablecimiento;
        this.codigoPuntoEmision = codigoPuntoEmision;
        this.tiempoMaximoEsperaRespuestaAutorizacion = tiempoMaximoEsperaRespuestaAutorizacion;
        this.tipoAmbiente = tipoAmbiente;
        this.tipoEmision = tipoEmision;
        this.tokenFirmar = tokenFirmar;
        this.facturas = facturas;
        this.productos = productos;
        this.establecimiento = establecimiento;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDireccionMatriz() {
        return direccionMatriz;
    }

    public void setDireccionMatriz(String direccionMatriz) {
        this.direccionMatriz = direccionMatriz;
    }

    public ObligadoContabilidad getObligadoContabilidad() {
        return obligadoContabilidad;
    }

    public void setObligadoContabilidad(ObligadoContabilidad obligadoContabilidad) {
        this.obligadoContabilidad = obligadoContabilidad;
    }

    public String getCodigoEstablecimiento() {
        return codigoEstablecimiento;
    }

    public void setCodigoEstablecimiento(String codigoEstablecimiento) {
        this.codigoEstablecimiento = codigoEstablecimiento;
    }

    public String getCodigoPuntoEmision() {
        return codigoPuntoEmision;
    }

    public void setCodigoPuntoEmision(String codigoPuntoEmision) {
        this.codigoPuntoEmision = codigoPuntoEmision;
    }

    public int getTiempoMaximoEsperaRespuestaAutorizacion() {
        return tiempoMaximoEsperaRespuestaAutorizacion;
    }

    public void setTiempoMaximoEsperaRespuestaAutorizacion(int tiempoMaximoEsperaRespuestaAutorizacion) {
        this.tiempoMaximoEsperaRespuestaAutorizacion = tiempoMaximoEsperaRespuestaAutorizacion;
    }

    public Ambiente getTipoAmbiente() {
        return tipoAmbiente;
    }

    public void setTipoAmbiente(Ambiente tipoAmbiente) {
        this.tipoAmbiente = tipoAmbiente;
    }

    public TipoEmision getTipoEmision() {
        return tipoEmision;
    }

    public void setTipoEmision(TipoEmision tipoEmision) {
        this.tipoEmision = tipoEmision;
    }

    public String getTokenFirmar() {
        return tokenFirmar;
    }

    public void setTokenFirmar(String tokenFirmar) {
        this.tokenFirmar = tokenFirmar;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }
}