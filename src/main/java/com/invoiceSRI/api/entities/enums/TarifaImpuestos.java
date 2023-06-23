package com.invoiceSRI.api.entities.enums;

public enum TarifaImpuestos {
    TARIFA_0(0),
    TARIFA_12(2),
    TARIFA_14(3),
    NO_OBJETO_IMPUESTO(6),
    EXENTO_IVA(7),
    IVA_DIFERENCIADO(9);

    private final int tarifaImpuesto;

    TarifaImpuestos(int tarifaImpuesto) {
        this.tarifaImpuesto = tarifaImpuesto;
    }

    public int getTarifaImpuesto() {
        return tarifaImpuesto;
    }
}
