package com.invoiceSRI.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;


import java.util.List;

@Entity
@Table(name = "emitter")
public class Emitter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emitter_id")
    public Long id;

    @Column(name = "ruc")
    private String ruc;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "commercial_name")
    private String commercialName;

    @Column(name = "parent_company_address")
    private String parentCompanyAddress;

    @Column(name = "obligated_accounting")
    private String obligatedAccounting;

    @Column(name = "establishment_code")
    private String establishmentCode;

    @Column(name = "emission_point_code")
    private String emissionPointCode;

    @Column(name = "maximum_waiting_time_authorization_response")
    private int maximumWaitingTimeAuthorizationResponse;

    @Column(name = "environment_type")
    private String environmentType;

    @Column(name = "emission_type")
    private String emissionType;

    @Column(name = "token_firmar")
    private String tokenFirmar;

    @OneToMany(mappedBy = "emitter")
    private List<Factura> facturas;

    @ManyToOne
    @JoinColumn(name = "establishment_id")
    private Establecimiento establecimiento;

    public Emitter() {}

    public Emitter(Long id, String ruc, String companyName, String commercialName, String parentCompanyAddress, String obligatedAccounting, String establishmentCode, String emissionPointCode, int maximumWaitingTimeAuthorizationResponse, String environmentType, String emissionType, String tokenFirmar, List<Factura> facturas, Establecimiento establecimiento) {
        this.id = id;
        this.ruc = ruc;
        this.companyName = companyName;
        this.commercialName = commercialName;
        this.parentCompanyAddress = parentCompanyAddress;
        this.obligatedAccounting = obligatedAccounting;
        this.establishmentCode = establishmentCode;
        this.emissionPointCode = emissionPointCode;
        this.maximumWaitingTimeAuthorizationResponse = maximumWaitingTimeAuthorizationResponse;
        this.environmentType = environmentType;
        this.emissionType = emissionType;
        this.tokenFirmar = tokenFirmar;
        this.facturas = facturas;
        this.establecimiento = establecimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCommercialName() {
        return commercialName;
    }

    public void setCommercialName(String commercialName) {
        this.commercialName = commercialName;
    }

    public String getParentCompanyAddress() {
        return parentCompanyAddress;
    }

    public void setParentCompanyAddress(String parentCompanyAddress) {
        this.parentCompanyAddress = parentCompanyAddress;
    }

    public String getObligatedAccounting() {
        return obligatedAccounting;
    }

    public void setObligatedAccounting(String obligatedAccounting) {
        this.obligatedAccounting = obligatedAccounting;
    }

    public String getEstablishmentCode() {
        return establishmentCode;
    }

    public void setEstablishmentCode(String establishmentCode) {
        this.establishmentCode = establishmentCode;
    }

    public String getEmissionPointCode() {
        return emissionPointCode;
    }

    public void setEmissionPointCode(String emissionPointCode) {
        this.emissionPointCode = emissionPointCode;
    }

    public int getMaximumWaitingTimeAuthorizationResponse() {
        return maximumWaitingTimeAuthorizationResponse;
    }

    public void setMaximumWaitingTimeAuthorizationResponse(int maximumWaitingTimeAuthorizationResponse) {
        this.maximumWaitingTimeAuthorizationResponse = maximumWaitingTimeAuthorizationResponse;
    }

    public String getEnvironmentType() {
        return environmentType;
    }

    public void setEnvironmentType(String environmentType) {
        this.environmentType = environmentType;
    }

    public String getEmissionType() {
        return emissionType;
    }

    public void setEmissionType(String emissionType) {
        this.emissionType = emissionType;
    }

    public String getTokenFirmar() {
        return tokenFirmar;
    }

    public void setTokenFirmar(String tokenFirmar) {
        this.tokenFirmar = tokenFirmar;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }
}