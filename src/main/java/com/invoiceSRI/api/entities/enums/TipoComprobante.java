package com.invoiceSRI.api.entities.enums;

public enum TipoComprobante {
    FACTURA(01),
    LIQUIDACION_DE_COMPRAS(03),
    NOTA_DE_CREDITO(04),
    NOTA_DE_DEBITO(05),
    GUIA_DE_REMISION(06),
    COMPROBANTE_DE_RETENCION(07);

    private final int tipoComprobante;

    TipoComprobante(int tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public int getTipoComprobante() {
        return tipoComprobante;
    }
}
