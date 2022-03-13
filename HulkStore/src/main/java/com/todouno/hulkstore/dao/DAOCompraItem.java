package com.todouno.hulkstore.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.todouno.hulkstore.model.CompraItem;

/**
 * Representa DAOCompraItem.
 */
@Repository
public class DAOCompraItem extends DAOGeneric<CompraItem>{

	public DAOCompraItem(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}

