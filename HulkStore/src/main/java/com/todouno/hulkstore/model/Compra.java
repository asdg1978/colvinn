package com.todouno.hulkstore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.todouno.hulkstore.enums.EnumCompraEstado;

/**
 * Representa una entidad de Compra.
 */
@Entity
@Table(name = "COMPRAS")
public class Compra extends BaseModelImpl {


    /**
     *
     */
    private static final long serialVersionUID = -8879681904822512634L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List < CompraItem > items;

    @Column(name = "IMPORTE_TOTAL", nullable = false)
    private Double importeTotal;

    @Column(name = "ESTADO", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumCompraEstado estado;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, updatable = false)
    private Usuario usuario;


    public Long getId() {
        return this.id;
    }



    public void setId(final Long id) {
        this.id = id;
    }



    public List < CompraItem > getItems() {
        return this.items;
    }



    public void setItems(final List < CompraItem > items) {
        this.items = items;
    }



    public Double getImporteTotal() {
        return this.importeTotal;
    }



    public void setImporteTotal(final Double importeTotal) {
        this.importeTotal = importeTotal;
    }



    public EnumCompraEstado getEstado() {
        return this.estado;
    }



    public void setEstado(final EnumCompraEstado estado) {
        this.estado = estado;
    }



    public Usuario getUsuario() {
        return this.usuario;
    }



    public void setUsuario(final Usuario usuario) {
        this.usuario = usuario;
    }


}
