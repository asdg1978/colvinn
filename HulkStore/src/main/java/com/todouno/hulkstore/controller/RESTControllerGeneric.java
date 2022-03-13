package com.todouno.hulkstore.controller;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.todouno.hulkstore.exception.ExceptionService;
import com.todouno.hulkstore.model.BaseModel;
import com.todouno.hulkstore.service.ServiceCompra;
import com.todouno.hulkstore.service.ServiceCompraItem;
import com.todouno.hulkstore.service.ServiceGeneric;
import com.todouno.hulkstore.service.ServiceMovimiento;
import com.todouno.hulkstore.service.ServiceProducto;
import com.todouno.hulkstore.service.ServiceUsuario;
import com.todouno.hulkstore.utils.Constants;

import io.swagger.annotations.ApiOperation;

public abstract class RESTControllerGeneric < T extends BaseModel > {

  //final public Logger logger = Logger.getLogger(this.getClass());

  @Autowired
  public HttpServletRequest request;

  @Autowired
  public HttpServletResponse response;

  @SuppressWarnings(Constants.SuppressWarnings_Rawtypes)
  private ServiceGeneric service;

  @Autowired
  private ServiceCompra serviceCompra;

  @Autowired
  private ServiceCompraItem serviceCompraItem;

  @Autowired
  private ServiceMovimiento serviceMovimiento;

  @Autowired
  private ServiceProducto serviceProducto;

  @Autowired
  private ServiceUsuario serviceUsuario;

  @SuppressWarnings(Constants.SuppressWarnings_Rawtypes)
  Map < String,
  ServiceGeneric > serviceMap;

  @SuppressWarnings(Constants.SuppressWarnings_Rawtypes)
  private void loadServices() {
    serviceMap = new HashMap < String, ServiceGeneric > ();
    serviceMap.put(Constants.ENTITY_COMPRA, this.serviceCompra);
    serviceMap.put(Constants.ENTITY_COMPRA_ITEM, this.serviceCompraItem);
    serviceMap.put(Constants.ENTITY_MOVIMIENTO, this.serviceMovimiento);
    serviceMap.put(Constants.ENTITY_PRODUCTO, this.serviceProducto);
    serviceMap.put(Constants.ENTITY_USUARIO, this.serviceUsuario);
  }

  private void findService(T request) {
    if (this.serviceMap == null) {
      loadServices();
    }
    this.service = serviceMap.get(getDomainClass().getName());
  }

  @SuppressWarnings("unchecked")
  public Class < T > getDomainClass() {
    ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
    return (Class < T > ) thisType.getActualTypeArguments()[0];
  }

  @PostMapping("/")
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "Creacioin de una unidad", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
  protected ResponseEntity < BaseModel > create(@RequestBody T request, @RequestHeader HttpHeaders httpHeaders) throws ExceptionService {
    findService(request);
    request.setId((Long) service.save(request));
    return ResponseEntity.ok((BaseModel) request);
  }

  @ApiOperation(value = "Elimina una unidad", httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_VALUE)
  @DeleteMapping("/delete/")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@RequestBody T request, @RequestHeader HttpHeaders headers) throws ExceptionService {
    findService(request);
    service.delete(request);
  }

  @ApiOperation(value = "Modificar una unidad", httpMethod = "PUT", produces = MediaType.APPLICATION_JSON_VALUE)
  @PutMapping("/")
  @ResponseStatus(HttpStatus.OK)
  public void update(@RequestBody T request, @RequestHeader HttpHeaders httpHeaders) throws ExceptionService {
    findService(request);
    service.update(request);
  }

  @SuppressWarnings(Constants.SuppressWarnings_Unchecked)
  @ApiOperation(value = "Obtiene una unidad mediante un id", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
  @DeleteMapping("/id/")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity < BaseModel > getById(@RequestBody T request, @RequestHeader HttpHeaders headers) throws ExceptionService {
    findService(request);
    return ResponseEntity.ok((BaseModel) service.getById(request));
  }

}