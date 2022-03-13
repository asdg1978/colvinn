package com.todouno.hulkstore.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.todouno.hulkstore.model.Usuario;

@Repository
public class DAOUsuario extends DAOGeneric<Usuario>{

	public DAOUsuario(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
