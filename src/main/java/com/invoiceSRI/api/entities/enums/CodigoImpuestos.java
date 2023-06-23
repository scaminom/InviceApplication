package com.invoiceSRI.api.entities.enums;

public enum CodigoImpuestos {
    IVA(2);

    private final int codigoImpuesto;

    private CodigoImpuestos(int codigoImpuesto) {
        this.codigoImpuesto = codigoImpuesto;
    }

    public int getCodigoImpuesto() {
        return this.codigoImpuesto;
    }
}
