package com.invoiceSRI.api.entities.enums;

public enum Ambiente {
    PRUEBAS(1),
    PRODUCCION(2);

    private final int ambiente;

    Ambiente(int ambiente) {
        this.ambiente = ambiente;
    }

    public int getAmbiente() {
        return ambiente;
    }
}
