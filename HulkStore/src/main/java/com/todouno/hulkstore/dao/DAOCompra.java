package com.todouno.hulkstore.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.todouno.hulkstore.model.Compra;

/**
 * Representa DAOCompra.
 */
@Repository
public class DAOCompra extends DAOGeneric < Compra > {

    public DAOCompra(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
