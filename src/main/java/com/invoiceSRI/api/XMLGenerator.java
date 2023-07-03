package com.invoiceSRI.api;

import com.invoiceSRI.api.entities.Factura;
import com.invoiceSRI.api.entities.constants.*;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

@Component
public class XMLGenerator {

    private String getTipoAmbiente(String tipoAmbiente) {
        String valorAmbiente = null;
        if (Ambiente.getPruebas().equals(tipoAmbiente)) {
            valorAmbiente = "1";
        } else if (Ambiente.getProduccion().equals(tipoAmbiente)) {
            valorAmbiente = "2";
        }
        return valorAmbiente;
    }

    private String getObligadoContabilidad(String obligadoContabilidad) {
        String valorObligadoContabilidad = null;
        if (ObligadoContabilidad.getNo().equals(obligadoContabilidad)) {
            valorObligadoContabilidad = "SI";
        } else if (ObligadoContabilidad.getSi().equals(obligadoContabilidad)) {
            valorObligadoContabilidad = "NO";
        }
        return valorObligadoContabilidad;
    }

    private String getTipoIdentificacion(String tipoIdentificacion) {
        String valorTipoIdentificacion = null;
        if (TipoIdentificacion.getRuc().equals(tipoIdentificacion)) {
            valorTipoIdentificacion = "04";
        } else if (TipoIdentificacion.getCedula().equals(tipoIdentificacion)) {
            valorTipoIdentificacion = "05";
        } else if (TipoIdentificacion.getPasaporte().equals(tipoIdentificacion)) {
            valorTipoIdentificacion = "06";
        } else if (TipoIdentificacion.getConsumidorFinal().equals(tipoIdentificacion)) {
            valorTipoIdentificacion = "07";
        } else if (TipoIdentificacion.getIdentificacionExterior().equals(tipoIdentificacion)) {
            valorTipoIdentificacion = "08";
        }
        return valorTipoIdentificacion;
    }

    private String getCodigoImpuesto(String codigoImpuesto) {
        String valorCodigoImpuesto = null;
        if (CodigoImpuestos.getIva().equals(codigoImpuesto)) {
            valorCodigoImpuesto = "2";
        } else if (CodigoImpuestos.getIce().equals(codigoImpuesto)) {
            valorCodigoImpuesto = "3";
        } else if (CodigoImpuestos.getIrbpnr().equals(codigoImpuesto)) {
            valorCodigoImpuesto = "5";
        }
        return valorCodigoImpuesto;
    }

    private String getTarifaImpuestos(String tarifaImpuesto) {
        String valorTarifaImpuesto = null;
        if (TarifaImpuestos.getTarifa0().equals(tarifaImpuesto)) {
            valorTarifaImpuesto = "0";
        } else if (TarifaImpuestos.getTarifa12().equals(tarifaImpuesto)) {
            valorTarifaImpuesto = "2";
        } else if (TarifaImpuestos.getTarifa14().equals(tarifaImpuesto)) {
            valorTarifaImpuesto = "3";
        } else if (TarifaImpuestos.getNoObjetoImpuesto().equals(tarifaImpuesto)) {
            valorTarifaImpuesto = "6";
        } else if (TarifaImpuestos.getExentoIva().equals(tarifaImpuesto)) {
            valorTarifaImpuesto = "7";
        } else if (TarifaImpuestos.getIvaDiferenciado().equals(tarifaImpuesto)) {
            valorTarifaImpuesto = "8";
        }
        return valorTarifaImpuesto;
    }



    public Document XMLBuilder(Factura facturaObject) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element factura = doc.createElement("factura");
            doc.appendChild(factura);

            factura.setAttribute("id", "comprobante");
            factura.setAttribute("version", "1.0.0");

            Element infoTributaria = doc.createElement("infoTributaria");
            factura.appendChild(infoTributaria);

            String tipoAmbiente = facturaObject.getEmisor().getTipoAmbiente();
            String valorAmbiente = getTipoAmbiente(tipoAmbiente);
            Element ambiente = doc.createElement("ambiente");
            ambiente.setTextContent(valorAmbiente);
            infoTributaria.appendChild(ambiente);

            Element tipoEmision = doc.createElement("tipoEmision");
            tipoEmision.setTextContent(facturaObject.getEmisor().getTipoEmision());
            infoTributaria.appendChild(tipoEmision);

            Element razonSocial = doc.createElement("razonSocial");
            razonSocial.setTextContent(facturaObject.getEmisor().getRazonSocial());
            infoTributaria.appendChild(razonSocial);

            Element nombreComercial = doc.createElement("nombreComercial");
            nombreComercial.setTextContent(facturaObject.getEmisor().getNombreComercial());
            infoTributaria.appendChild(nombreComercial);

            Element ruc = doc.createElement("ruc");
            ruc.setTextContent(facturaObject.getEmisor().getRuc());
            infoTributaria.appendChild(ruc);

            Element claveAcceso = doc.createElement("claveAcceso");
            claveAcceso.setTextContent(facturaObject.getEmisor().getTokenFirmar());
            infoTributaria.appendChild(claveAcceso);

            Element codDoc = doc.createElement("codDoc");
            codDoc.setTextContent("01");
            infoTributaria.appendChild(codDoc);

            Element estab = doc.createElement("estab");
            estab.setTextContent(facturaObject.getEmisor().getCodigoEstablecimiento());
            infoTributaria.appendChild(estab);

            Element ptoEmi = doc.createElement("ptoEmi");
            ptoEmi.setTextContent(facturaObject.getEmisor().getCodigoPuntoEmision());
            infoTributaria.appendChild(ptoEmi);

            Element secuencial = doc.createElement("secuencial");
            secuencial.setTextContent(Long.toString(facturaObject.getNumeroSecuencial()));
            infoTributaria.appendChild(secuencial);

            Element dirMatriz = doc.createElement("dirMatriz");
            dirMatriz.setTextContent(facturaObject.getEmisor().getDireccionMatriz());
            infoTributaria.appendChild(dirMatriz);

            Element infoFactura = doc.createElement("infoFactura");
            factura.appendChild(infoFactura);

            Element fechaEmision = doc.createElement("fechaEmision");
            fechaEmision.setTextContent(String.valueOf(facturaObject.getFechaEmision()));
            infoFactura.appendChild(fechaEmision);

            Element dirEstablecimiento = doc.createElement("dirEstablecimiento");
            dirEstablecimiento.setTextContent(facturaObject.getEmisor().getEstablecimiento().getDireccion());
            infoFactura.appendChild(dirEstablecimiento);

            String obligadoContabilidadSRI = facturaObject.getEmisor().getObligadoContabilidad();
            String valorObligadoContabilidad = getObligadoContabilidad(obligadoContabilidadSRI);
            Element obligadoContabilidad = doc.createElement("obligadoContabilidad");
            obligadoContabilidad.setTextContent(valorObligadoContabilidad);
            infoFactura.appendChild(obligadoContabilidad);

            String tipoIdentificacion = facturaObject.getCliente().getTipoIdentificacion();
            String valorTipoIdentificacion = getTipoIdentificacion(tipoIdentificacion);
            Element tipoIdentificacionComprobador = doc.createElement("tipoIdentificacionComprobador");
            tipoIdentificacionComprobador.setTextContent(valorTipoIdentificacion);
            infoFactura.appendChild(tipoIdentificacionComprobador);

            Element razonSocialComprador = doc.createElement("razonSocialComprador");
            razonSocialComprador.setTextContent(facturaObject.getCliente().getRazonSocial());
            infoFactura.appendChild(razonSocialComprador);

            Element identificacionComprador = doc.createElement("identificacionComprador");
            identificacionComprador.setTextContent(facturaObject.getCliente().getNumeroIdentificacion());
            infoFactura.appendChild(identificacionComprador);

            Element totalSinImpuestos = doc.createElement("TotalSinImpuestos");
            totalSinImpuestos.setTextContent(String.valueOf(facturaObject.getSubtotalSinImpuesto()));
            infoFactura.appendChild(totalSinImpuestos);

            Element totalDescuento = doc.createElement("TotalDescuento");
            totalDescuento.setTextContent(String.valueOf(facturaObject.getTotalDescuento()));
            infoFactura.appendChild(totalDescuento);

            Element totalConImpuestos = doc.createElement("totalConImpuestos");
            infoFactura.appendChild(totalConImpuestos);

            Element totalImpuesto = doc.createElement("totalImpuesto");
            totalConImpuestos.appendChild(totalImpuesto);

            String codigoImpuesto = facturaObject.getItems().get(1).getProducto().getCodigoImpuestos();
            String valorCodigoImpuesto = getCodigoImpuesto(codigoImpuesto);
            Element codigo = doc.createElement("codigo");
            codigo.setTextContent(valorCodigoImpuesto);
            totalImpuesto.appendChild(codigo);

            String tarifaImpuesto = facturaObject.getItems().get(1).getProducto().getTarifaImpuestos();
            String valorTarifaImpuesto = getTarifaImpuestos(tarifaImpuesto);
            Element codigoPorcentaje = doc.createElement("codigoPorcentaje");
            codigoPorcentaje.setTextContent(valorTarifaImpuesto);
            totalImpuesto.appendChild(codigoPorcentaje);

            Element baseImponible = doc.createElement("baseImponible");
            baseImponible.setTextContent(String.valueOf(facturaObject.getSubtotalSinImpuesto()));
            totalImpuesto.appendChild(baseImponible);

            Element valor = doc.createElement("valor");
            valor.setTextContent(String.valueOf(facturaObject.getTotal()));
            totalImpuesto.appendChild(valor);

            Element propina = doc.createElement("propina");
            propina.setTextContent(String.valueOf(facturaObject.getPropina()));
            infoFactura.appendChild(propina);

            Element importeTotal = doc.createElement("importeTotal");
            importeTotal.setTextContent("1.12");
            infoFactura.appendChild(importeTotal);

            Element moneda = doc.createElement("moneda");
            moneda.setTextContent("DOLAR");
            infoFactura.appendChild(moneda);

            Element pagos = doc.createElement("pagos");
            factura.appendChild(pagos);

            Element pago = doc.createElement("pago");
            pagos.appendChild(pago);

            Element formaPago = doc.createElement("formaPago");
            formaPago.setTextContent("01");
            pago.appendChild(formaPago);

            Element total = doc.createElement("total");
            total.setTextContent("1.12");
            pago.appendChild(total);

            Element plazo = doc.createElement("plazo");
            plazo.setTextContent("0");
            pago.appendChild(plazo);

            Element unidadTiempo = doc.createElement("unidadTiempo");
            unidadTiempo.setTextContent("dias");
            pago.appendChild(unidadTiempo);

            Element detalles = doc.createElement("detalles");
            factura.appendChild(detalles);

            Element detalle = doc.createElement("detalle");
            detalles.appendChild(detalle);

            Element codigoPrincipal = doc.createElement("codigoPrincipal");
            codigoPrincipal.setTextContent("001");
            detalle.appendChild(codigoPrincipal);

            Element descripcion = doc.createElement("descripcion");
            descripcion.setTextContent("descripcion del producto");
            detalle.appendChild(descripcion);

            Element cantidad = doc.createElement("cantidad");
            cantidad.setTextContent("1");
            detalle.appendChild(cantidad);

            Element precioUnitario = doc.createElement("precioUnitario");
            precioUnitario.setTextContent("1.00");
            detalle.appendChild(precioUnitario);

            Element descuento = doc.createElement("descuento");
            descuento.setTextContent("0.00");
            detalle.appendChild(descuento);

            Element precioTotalSinImpuesto = doc.createElement("precioTotalSinImpuesto");
            precioTotalSinImpuesto.setTextContent("1.00");
            detalle.appendChild(precioTotalSinImpuesto);

            Element impuestos = doc.createElement("impuestos");
            detalle.appendChild(impuestos);

            Element impuesto = doc.createElement("impuesto");
            impuestos.appendChild(impuesto);

            Element codigoImpuesto = doc.createElement("codigo");
            codigoImpuesto.setTextContent("2");
            impuesto.appendChild(codigoImpuesto);

            Element codigoPorcentajeImpuesto = doc.createElement("codigoPorcentaje");
            codigoPorcentajeImpuesto.setTextContent("2");
            impuesto.appendChild(codigoPorcentajeImpuesto);

            Element tarifa = doc.createElement("tarifa");
            tarifa.setTextContent("0.00");
            impuesto.appendChild(tarifa);

            Element baseImponibleImpuesto = doc.createElement("baseImponible");
            baseImponibleImpuesto.setTextContent("1.00");
            impuesto.appendChild(baseImponibleImpuesto);

            Element valorImpuesto = doc.createElement("valor");
            valorImpuesto.setTextContent("0.00");
            impuesto.appendChild(valorImpuesto);

            Element infoAdicional = doc.createElement("infoAdicional");
            factura.appendChild(infoAdicional);

            Element campoAdicional = doc.createElement("campoAdicional");
            campoAdicional.setTextContent("correo@dominio.com");
            campoAdicional.setAttribute("nombre", "email");
            infoAdicional.appendChild(campoAdicional);

            saveXML(doc);

            return doc;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveXML(Document doc) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("factura.xml"));
            transformer.transform(source, result);
            System.out.println("XML generado correctamente.");
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}

