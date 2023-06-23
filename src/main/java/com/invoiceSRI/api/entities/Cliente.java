package com.invoiceSRI.api.entities;

import com.invoiceSRI.api.entities.enums.TipoIdentificacion;
import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Column(name = "apellidos_nombres_razon_social")
    private String razonSocial;

    @Column(name = "tipo_identificacion")
    @Enumerated(EnumType.ORDINAL)
    private TipoIdentificacion tipoIdentificacion;

    @Id
    @Column(name = "numero_identificacion")
    private String numeroIdentificacion;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    public Cliente() {
    }

    public Cliente(String razonSocial, TipoIdentificacion tipoIdentificacion, String numeroIdentificacion, String correoElectronico) {
        this.razonSocial = razonSocial;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.correoElectronico = correoElectronico;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}


