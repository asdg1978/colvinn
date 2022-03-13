package com.todouno.hulkstore.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.todouno.hulkstore.model.Producto;

@Repository
public class DAOProducto extends DAOGeneric<Producto>{

	public DAOProducto(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
