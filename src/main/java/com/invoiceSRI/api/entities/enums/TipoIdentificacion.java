package com.invoiceSRI.api.entities.enums;

public enum TipoIdentificacion {
    RUC(4),
    CEDULA(5),
    PASAPORTE(6),
    CONSUMIDOR_FINAL(7),
    IDENTIFICACION_EXTERIOR(8);

    private final int tipoIdentificacion;

    TipoIdentificacion(int tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public int getTipoIdentificacion() {
        return tipoIdentificacion;
    }
}

