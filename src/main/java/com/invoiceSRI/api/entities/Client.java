package com.invoiceSRI.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "identification_type")
    private String identificationType;

    @Column(name = "identification_number")
    private String identificationNumber;

    @Column(name = "email")
    private String email;

    public Client() {
    }

    public Client(Long id, String companyName, String identificationType, String identificationNumber, String email) {
        this.id = id;
        this.companyName = companyName;
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}