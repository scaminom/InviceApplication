package com.invoiceSRI.api.entities.enums;

public enum FormasPago {
    SIN_UTILIZACION_DEL_SISTEMA_FINANCIERO(01),
    COMPENSACION_DE_DEUDAS(15),
    TARJETA_DE_DEBITO(16),
    DINERO_ELECTRONICO(17),
    TARJETA_PREPAGO(18),
    TARJETA_DE_CREDITO(19),
    OTROS_CON_UTILIZACION_DEL_SISTEMA_FINANCIERO(20),
    ENDOSO_DE_TITULOS(21);

    private final int formaPago;

    private FormasPago(int formaPago) {
        this.formaPago = formaPago;
    }

    public int getFormaPago() {
        return this.formaPago;
    }
}
