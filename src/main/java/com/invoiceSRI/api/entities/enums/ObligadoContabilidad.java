package com.invoiceSRI.api.entities.enums;

public enum ObligadoContabilidad {
    SI("SI"),
    NO("NO");

    private final String obligadoContabilidad;

    ObligadoContabilidad(String obligadoContabilidad) {
        this.obligadoContabilidad = obligadoContabilidad;
    }

    public String getObligadoContabilidad() {
        return obligadoContabilidad;
    }
}
