package com.todouno.hulkstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.todouno.hulkstore.enums.EnumMovimientoTipo;

/**
 * Representa una entidad de Movimiento.
 */
@Entity
@Table(name = "MOVIMIENTOS")
public class Movimiento extends BaseModelImpl {


    /**
     *
     */
    private static final long serialVersionUID = 2953245006408314648L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TIPO_MOVIMIENTO", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumMovimientoTipo tipoMovimiento;


    @Column(name = "PRODUCTO", nullable = false)
    private Producto producto;

    @Column(name = "CANTIDAD", nullable = false)
    private Long cantidad;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public EnumMovimientoTipo getTipoMovimiento() {
        return this.tipoMovimiento;
    }

    public void setTipoMovimiento(final EnumMovimientoTipo tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(final Producto producto) {
        this.producto = producto;
    }

    public Long getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(final Long cantidad) {
        this.cantidad = cantidad;
    }


}
