package com.electromechanics.backend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "SOLICITUDES_CLIENTE")
public class SolicitudClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false, length = 1000)
    private String descripcion;

    @Column(nullable = false, length = 50)
    private String estado;

    @Column(nullable = false, length = 100)
    private String tipo;

    public SolicitudClienteEntity() {
    }

    public SolicitudClienteEntity(
            String titulo,
            String descripcion,
            String estado,
            String tipo
    ) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
