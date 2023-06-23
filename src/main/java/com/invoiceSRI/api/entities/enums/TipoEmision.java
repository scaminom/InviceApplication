package com.invoiceSRI.api.entities.enums;

public enum TipoEmision {
    NORMAL(1);

    private final int tipoEmision;

    TipoEmision(int tipoEmision) {
        this.tipoEmision = tipoEmision;
    }

    public int getTipoEmision() {
        return tipoEmision;
    }
}
