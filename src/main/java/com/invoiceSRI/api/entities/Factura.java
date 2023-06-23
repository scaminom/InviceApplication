package com.invoiceSRI.api.entities;


import com.invoiceSRI.api.entities.enums.FormasPago;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @Column(name = "numero_secuencial")
    private long numeroSecuencial;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "identificacion")
    private String identificacion;

    @Column(name = "fecha_emision")
    private int fechaEmision;

    @Column(name = "numero_guia_remision")
    private int numeroGuiaRemision;

    @Column(name = "codigo_numerico")
    private int codigoNumerico;

    @Column(name = "digito_verificador")
    private int digitoVerificador;

    @Column(name = "forma_pago")
    private FormasPago formaPago;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "factura_producto",
            joinColumns = @JoinColumn(name = "factura_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id"))
    private List<Producto> productos;

    @ManyToOne
    @JoinColumn(name = "emisor_id")
    private Emisor emisor;

    public Factura() {
    }

    public Factura(long numeroSecuencial, String razonSocial, String identificacion, int fechaEmision, int numeroGuiaRemision, int codigoNumerico, int digitoVerificador, FormasPago formaPago, Cliente cliente, List<Producto> productos, Emisor emisor) {
        this.numeroSecuencial = numeroSecuencial;
        this.razonSocial = razonSocial;
        this.identificacion = identificacion;
        this.fechaEmision = fechaEmision;
        this.numeroGuiaRemision = numeroGuiaRemision;
        this.codigoNumerico = codigoNumerico;
        this.digitoVerificador = digitoVerificador;
        this.formaPago = formaPago;
        this.cliente = cliente;
        this.productos = productos;
        this.emisor = emisor;
    }

    public long getNumeroSecuencial() {
        return numeroSecuencial;
    }

    public void setNumeroSecuencial(int numeroSecuencial) {
        this.numeroSecuencial = numeroSecuencial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(int fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public int getNumeroGuiaRemision() {
        return numeroGuiaRemision;
    }

    public void setNumeroGuiaRemision(int numeroGuiaRemision) {
        this.numeroGuiaRemision = numeroGuiaRemision;
    }

    public int getCodigoNumerico() {
        return codigoNumerico;
    }

    public void setCodigoNumerico(int codigoNumerico) {
        this.codigoNumerico = codigoNumerico;
    }

    public int getDigitoVerificador() {
        return digitoVerificador;
    }

    public void setDigitoVerificador(int digitoVerificador) {
        this.digitoVerificador = digitoVerificador;
    }

    public void setNumeroSecuencial(long numeroSecuencial) {
        this.numeroSecuencial = numeroSecuencial;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Emisor getEmisor() {
        return emisor;
    }

    public void setEmisor(Emisor emisor) {
        this.emisor = emisor;
    }

    public static int calcularDigitoVerificador(String claveAcceso) {
        int factorChequeo = 2;
        int suma = 0;

        for (int i = claveAcceso.length() - 1; i >= 0; i--) {
            int digito = Character.getNumericValue(claveAcceso.charAt(i));
            suma += digito * factorChequeo;

            factorChequeo++;
            if (factorChequeo > 7) {
                factorChequeo = 2;
            }
        }

        int modulo = suma % 11;
        int digitoVerificador;

        if (modulo == 0) {
            digitoVerificador = 0;
        } else if (modulo == 1) {
            digitoVerificador = 1;
        } else {
            digitoVerificador = 11 - modulo;
        }

        return digitoVerificador;
    }

    public FormasPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormasPago formaPago) {
        this.formaPago = formaPago;
    }
}


