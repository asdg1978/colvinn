package com.todouno.hulkstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Representa una entidad de Compra Item.
 */
@Entity
@Table(name = "COMPRA_ITEMS")
public class CompraItem extends BaseModelImpl {


    /**
     *
     */
    private static final long serialVersionUID = -7689298968849687087L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PRODUCTO", nullable = false)
    private Producto producto;

    @Column(name = "CANTIDAD", nullable = false)
    private Long cantidad;

    @ManyToOne
    @JoinColumn(name = "id_compra", nullable = false, updatable = false)
    private Compra compra;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(final Producto producto) {
        this.producto = producto;
    }

    public Compra getCompra() {
        return this.compra;
    }

    public void setCompra(final Compra compra) {
        this.compra = compra;
    }



}
