package com.invoiceSRI.api.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "factura_id")
    private Long id;
    @Column(name = "numero_secuencial")
    private long numeroSecuencial;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "identificacion")
    private String identificacion;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha_emision")
    private Date fechaEmision;
    @Column(name = "numero_guia_remision")
    private int numeroGuiaRemision;
    @Column(name = "codigo_numerico")
    private int codigoNumerico;
    @Column(name = "digito_verificador")
    private int digitoVerificador;
    @Column(name = "forma_pago")
    private String formaPago;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Client client;
    @Column(name = "subtotal_sin_impuesto")
    private double subtotalSinImpuesto;
    @Column(name = "subtotal_12")
    private double subtotal12;
    @Column(name = "subtotal_0")
    private double subtotal0;
    @Column(name = "subtotal_no_objeto_iva")
    private double subtotalNoObjetoIva;
    @Column(name = "subtotal_exento_iva")
    private double subtotalExentoIva;
    @Column(name = "total_sin_impuesto")
    private double totalDescuento;
    @Column(name = "valor_ice")
    private double valorIce;
    @Column(name = "valor_irbpnr")
    private double valorIRBPNR;
    @Column(name = "iva_12")
    private double iva12;
    private double propina;
    private double total;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Items> items;

    @ManyToOne
    @JoinColumn(name = "emisor_id")
    private Emitter emitter;

    @ManyToOne
    @JoinColumn(name = "establecimiento_id")
    private Establecimiento establecimiento;

    public Factura() {
    }

    public Factura(long numeroSecuencial, String razonSocial, String identificacion, Date fechaEmision, int numeroGuiaRemision, int codigoNumerico, int digitoVerificador, String formaPago, Client client, List<Items> items, Emitter emitter, Establecimiento establecimiento) {
        this.numeroSecuencial = numeroSecuencial;
        this.razonSocial = razonSocial;
        this.identificacion = identificacion;
        this.fechaEmision = fechaEmision;
        this.numeroGuiaRemision = numeroGuiaRemision;
        this.codigoNumerico = codigoNumerico;
        this.digitoVerificador = digitoVerificador;
        this.formaPago = formaPago;
        this.client = client;
        this.items = items;
        this.emitter = emitter;
        this.establecimiento = establecimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
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

    public Client getCliente() {
        return client;
    }

    public void setCliente(Client client) {
        this.client = client;
    }

    public Emitter getEmisor() {
        return emitter;
    }

    public void setEmisor(Emitter emitter) {
        this.emitter = emitter;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
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

    public void calculateTotalDiscount() {
        for (Items item : items) {
            totalDescuento += item.getDescuento();
        }
    }

    public void calculateSubtotal() {
        for (Items item : items) {
            subtotalSinImpuesto += item.getTotal();
        }
    }

    public double getSubtotalSinImpuesto() {
        return subtotalSinImpuesto;
    }

    public void setSubtotalSinImpuesto(double subtotalSinImpuesto) {
        this.subtotalSinImpuesto = subtotalSinImpuesto;
    }

    public double getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(double totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPropina() {
        return propina;
    }

    public void setPropina(double propina) {
        this.propina = propina;
    }
}


