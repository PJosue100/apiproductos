package com.pj.apiproductos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "imagen_url", nullable = false)
    private String imagenUrl;

    @NotNull
    @Lob
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @NotNull
    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "creado_en")
    private Instant creadoEn;

    @Size(max = 2000)
    @ColumnDefault("' '")
    @Column(name = "descripcion_extensa", length = 2000)
    private String descripcionExtensa;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "unidades_disponibles", nullable = false)
    private Integer unidadesDisponibles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Instant getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(Instant creadoEn) {
        this.creadoEn = creadoEn;
    }

    public String getDescripcionExtensa() {
        return descripcionExtensa;
    }

    public void setDescripcionExtensa(String descripcionExtensa) {
        this.descripcionExtensa = descripcionExtensa;
    }

    public Integer getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(Integer unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }


    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", imagenUrl='" + imagenUrl + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", creadoEn=" + creadoEn +
                ", descripcionExtensa='" + descripcionExtensa + '\'' +
                ", unidadesDisponibles=" + unidadesDisponibles +
                '}';
    }
}