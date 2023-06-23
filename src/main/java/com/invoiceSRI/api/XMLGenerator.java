package com.invoiceSRI.api;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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

    public void generateXMLFromTables() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element factura = doc.createElement("factura");
            doc.appendChild(factura);

            factura.setAttribute("id", "comprobante");
            factura.setAttribute("version", "1.00");

            Element infoTributaria = doc.createElement("infoTributaria");
            factura.appendChild(infoTributaria);

            Element ambiente = doc.createElement("ambiente");
            ambiente.setTextContent("1");
            infoTributaria.appendChild(ambiente);

            Element tipoEmision = doc.createElement("tipoEmision");
            tipoEmision.setTextContent("1");
            infoTributaria.appendChild(tipoEmision);

            Element razonSocial = doc.createElement("razonSocial");
            razonSocial.setTextContent("NOMBRE DE LA EMPRESA S.A");
            infoTributaria.appendChild(razonSocial);

            Element nombreComercial = doc.createElement("nombreComercial");
            nombreComercial.setTextContent("NOMBRE DE LA EMPRESA S.A");
            infoTributaria.appendChild(nombreComercial);

            Element ruc = doc.createElement("ruc");
            ruc.setTextContent("12347891001");
            infoTributaria.appendChild(ruc);

            Element claveAcceso = doc.createElement("claveAcceso");
            claveAcceso.setTextContent("1789042345678901234567890123456789012345678901243");
            infoTributaria.appendChild(claveAcceso);

            Element codDoc = doc.createElement("codDoc");
            codDoc.setTextContent("01");
            infoTributaria.appendChild(codDoc);

            Element estab = doc.createElement("estab");
            estab.setTextContent("001");
            infoTributaria.appendChild(estab);

            Element ptoEmi = doc.createElement("ptoEmi");
            ptoEmi.setTextContent("001");
            infoTributaria.appendChild(ptoEmi);

            Element secuencial = doc.createElement("secuencial");
            secuencial.setTextContent("000001234");
            infoTributaria.appendChild(secuencial);

            Element dirMatriz = doc.createElement("dirMatriz");
            dirMatriz.setTextContent("DIRECCION DE LA EMPRESA");
            infoTributaria.appendChild(dirMatriz);

            Element infoFactura = doc.createElement("infoFactura");
            factura.appendChild(infoFactura);

            Element fechaEmision = doc.createElement("fechaEmision");
            fechaEmision.setTextContent("15/06/2020");
            infoFactura.appendChild(fechaEmision);

            Element dirEstablecimiento = doc.createElement("dirEstablecimiento");
            dirEstablecimiento.setTextContent("DIRECCION ESTABLECIMIENTO");
            infoFactura.appendChild(dirEstablecimiento);

            Element obligadoContabilidad = doc.createElement("obligadoContabilidad");
            obligadoContabilidad.setTextContent("SI");
            infoFactura.appendChild(obligadoContabilidad);

            Element tipoIdentificacionComprobador = doc.createElement("tipoIdentificacionComprobador");
            tipoIdentificacionComprobador.setTextContent("05");
            infoFactura.appendChild(tipoIdentificacionComprobador);

            Element razonSocialComprador = doc.createElement("razonSocialComprador");
            razonSocialComprador.setTextContent("NOMBRE DEL COMPRADOR");
            infoFactura.appendChild(razonSocialComprador);

            Element identificacionComprador = doc.createElement("identificacionComprador");
            identificacionComprador.setTextContent("1234567891");
            infoFactura.appendChild(identificacionComprador);

            Element TotalSinImpuestos = doc.createElement("TotalSinImpuestos");
            TotalSinImpuestos.setTextContent("1.00");
            infoFactura.appendChild(TotalSinImpuestos);

            Element TotalDescuento = doc.createElement("TotalDescuento");
            TotalDescuento.setTextContent("0.00");
            infoFactura.appendChild(TotalDescuento);

            Element totalConImpuestos = doc.createElement("totalConImpuestos");
            infoFactura.appendChild(totalConImpuestos);

            Element totalImpuesto = doc.createElement("totalImpuesto");
            totalConImpuestos.appendChild(totalImpuesto);

            Element codigo = doc.createElement("codigo");
            codigo.setTextContent("2");
            totalImpuesto.appendChild(codigo);

            Element codigoPorcentaje = doc.createElement("codigoPorcentaje");
            codigoPorcentaje.setTextContent("0");
            totalImpuesto.appendChild(codigoPorcentaje);

            Element baseImponible = doc.createElement("baseImponible");
            baseImponible.setTextContent("1.00");
            totalImpuesto.appendChild(baseImponible);

            Element valor = doc.createElement("valor");
            valor.setTextContent("0.12");
            totalImpuesto.appendChild(valor);

            Element propina = doc.createElement("propina");
            propina.setTextContent("0.00");
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

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("factura.xml"));
            transformer.transform(source, result);

            System.out.println("XML generado correctamente.");

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}

