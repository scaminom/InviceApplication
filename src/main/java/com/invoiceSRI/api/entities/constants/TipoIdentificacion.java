package com.invoiceSRI.api.entities.constants;

public final class TipoIdentificacion {
    private static final String RUC = "04";
    private static final String CEDULA = "05";
    private static final String PASAPORTE = "06";
    private static final String CONSUMIDOR_FINAL = "07";
    private static final String IDENTIFICACION_EXTERIOR = "08";

    public static String getRuc() {
        return RUC;
    }

    public static String getCedula() {
        return CEDULA;
    }

    public static String getPasaporte() {
        return PASAPORTE;
    }

    public static String getConsumidorFinal() {
        return CONSUMIDOR_FINAL;
    }

    public static String getIdentificacionExterior() {
        return IDENTIFICACION_EXTERIOR;
    }
}