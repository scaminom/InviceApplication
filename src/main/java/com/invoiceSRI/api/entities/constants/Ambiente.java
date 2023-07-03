package com.invoiceSRI.api.entities.constants;

public final class Ambiente {
    private static final String PRUEBAS = "1";
    private static final String PRODUCCION = "2";

    public static String getPruebas() {
        return PRUEBAS;
    }

    public static String getProduccion() {
        return PRODUCCION;
    }
}
