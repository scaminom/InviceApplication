package com.invoiceSRI.api.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "establecimiento")
public class Establecimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private int codigo;
    private String direccion;
    private boolean activo;

    @OneToMany(mappedBy = "establecimiento")
    private List<Emisor> emisores;

    public Establecimiento() {}

    public Establecimiento(String nombre, int codigo, String direccion, boolean activo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.direccion = direccion;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Emisor> getEmisores() {
        return emisores;
    }

    public void setEmisores(List<Emisor> emisores) {
        this.emisores = emisores;
    }
}
