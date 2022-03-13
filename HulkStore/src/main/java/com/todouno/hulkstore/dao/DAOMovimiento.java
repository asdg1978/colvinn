package com.todouno.hulkstore.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.todouno.hulkstore.model.Movimiento;

@Repository
public class DAOMovimiento extends DAOGeneric<Movimiento>{

	public DAOMovimiento(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
