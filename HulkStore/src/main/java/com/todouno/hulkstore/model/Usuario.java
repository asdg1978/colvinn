package com.todouno.hulkstore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * Representa una entidad de Usuario.
 */
@Entity
@Table(name = "USUARIOS")
public class Usuario extends BaseModelImpl {
    /**
     *
     */
    private static final long serialVersionUID = 5463470207790571497L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USUARIO", nullable = false)
    private String usuario;

    @Column(name = "CONTRASENIA", nullable = false)
    private String contrasenia;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List < Compra > compras;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(final String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(final String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public List < Compra > getCompras() {
        return this.compras;
    }

    public void setCompras(final List < Compra > compras) {
        this.compras = compras;
    }






}
