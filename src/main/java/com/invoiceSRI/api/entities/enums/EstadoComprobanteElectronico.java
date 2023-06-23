package com.invoiceSRI.api.entities.enums;

public enum EstadoComprobanteElectronico {
    EN_PROCESAMIENTO("PPR"),
    AUTORIZADO("AUT"),
    NO_AUTORIZADO("NAT");

    private final String estado;

    private EstadoComprobanteElectronico(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return this.estado;
    }
}
