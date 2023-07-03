package com.invoiceSRI.api.entities.constants;

public final class TarifaImpuestos {
    private static final String TARIFA_0 = "0";
    private static final String TARIFA_12 = "2";
    private static final String TARIFA_14 = "3";
    private static final String NO_OBJETO_IMPUESTO = "6";
    private static final String EXENTO_IVA = "7";
    private static final String IVA_DIFERENCIADO = "9";

    public static String getTarifa0() {
        return TARIFA_0;
    }

    public static String getTarifa12() {
        return TARIFA_12;
    }

    public static String getTarifa14() {
        return TARIFA_14;
    }

    public static String getNoObjetoImpuesto() {
        return NO_OBJETO_IMPUESTO;
    }

    public static String getExentoIva() {
        return EXENTO_IVA;
    }

    public static String getIvaDiferenciado() {
        return IVA_DIFERENCIADO;
    }
}
