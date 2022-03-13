package com.todouno.hulkstore.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.todouno.hulkstore.dao.DAOCompra;
import com.todouno.hulkstore.dao.DAOCompraItem;
import com.todouno.hulkstore.dao.DAOGeneric;
import com.todouno.hulkstore.dao.DAOMovimiento;
import com.todouno.hulkstore.dao.DAOProducto;
import com.todouno.hulkstore.dao.DAOUsuario;
import com.todouno.hulkstore.exception.ExceptionDAO;
import com.todouno.hulkstore.exception.ExceptionService;
import com.todouno.hulkstore.model.BaseModel;
import com.todouno.hulkstore.utils.Constants;



/**
 * Representa un servicio generico.
 * @param <T> generica
 */
public abstract class ServiceGeneric < T > {


    @SuppressWarnings(Constants.SuppressWarnings_Rawtypes)
    private Map < String, DAOGeneric > daoMap;

    @SuppressWarnings(Constants.SuppressWarnings_Rawtypes)
    private DAOGeneric dao;

    private DAOCompra daoCompra;

    private DAOCompraItem daoCompraItem;

    private DAOMovimiento daoMovimiento;

    private DAOProducto daoProducto;

    private DAOUsuario daoUsuario;

    private Class < T > domainClass;

    @SuppressWarnings(Constants.SuppressWarnings_Rawtypes)
    private void loadDaos() {
        this.daoMap = new HashMap < String, DAOGeneric > ();
        this.daoMap.put(Constants.ENTITY_COMPRA, this.daoCompra);
        this.daoMap.put(Constants.ENTITY_COMPRA_ITEM, this.daoCompraItem);
        this.daoMap.put(Constants.ENTITY_MOVIMIENTO, this.daoMovimiento);
        this.daoMap.put(Constants.ENTITY_PRODUCTO, this.daoProducto);
        this.daoMap.put(Constants.ENTITY_USUARIO, this.daoUsuario);
    }


    @SuppressWarnings(Constants.SuppressWarnings_Unchecked)
    public T getById(final T entity) throws ExceptionService {
        findDAO();
        try {
            return (T) this.dao.get(((BaseModel) entity).getId());
        } catch (ExceptionDAO e) {
            throw new ExceptionService(e);
        }
    }

    @SuppressWarnings(Constants.SuppressWarnings_Unchecked)
    public List < T > find(final String hql, final Object...params) throws ExceptionService {
        findDAO();
        try {
            return this.dao.find(hql, params);
        } catch (ExceptionDAO e) {
            throw new ExceptionService(e);
        }
    }

    @SuppressWarnings(Constants.SuppressWarnings_Unchecked)
    public List < T > list() throws ExceptionService {
        findDAO();
        try {
            return this.dao.list();
        } catch (ExceptionDAO e) {
            throw new ExceptionService(e);
        }
    }

    public Serializable save(final Object o) throws ExceptionService {
        findDAO();
        try {
            return this.dao.save(o);
        } catch (ExceptionDAO e) {
            throw new ExceptionService(e);
        }
    }

    public void update(final Object o) throws ExceptionService {
        findDAO();
        try {
            this.dao.update(o);
        } catch (ExceptionDAO e) {
            throw new ExceptionService(e);
        }
    }

    public void delete(final Object o) throws ExceptionService {
        findDAO();
        try {
            this.dao.delete(o);
        } catch (ExceptionDAO e) {
            throw new ExceptionService(e);
        }
    }

    private void findDAO() throws ExceptionService {
        if (this.daoMap == null) {
            loadDaos();
            this.dao = this.daoMap.get(getDomainClass().getName());
        }
    }

    @SuppressWarnings(Constants.SuppressWarnings_Unchecked)
    public Class < T > getDomainClass() {
        if (this.domainClass == null) {
            final ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
            this.domainClass = (Class < T > ) thisType.getActualTypeArguments()[0];
        }
        return this.domainClass;
    }

}
