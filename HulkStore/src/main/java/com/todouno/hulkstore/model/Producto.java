package com.todouno.hulkstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Representa una entidad de Producto.
 */
@Entity
@Table(name = "PRODUCTOS")
public class Producto extends BaseModelImpl {

    private static final long serialVersionUID = 5659591582000016108L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "STOCK", nullable = false)
    private Long stock;

    @Column(name = "PRECIO_UNITARIO", nullable = false)
    private Double precioUnitario;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public Long getStock() {
        return this.stock;
    }

    public void setStock(final Long stock) {
        this.stock = stock;
    }

    public Double getPrecioUnitario() {
        return this.precioUnitario;
    }

    public void setPrecioUnitario(final Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }



}
