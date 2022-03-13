package com.todouno.hulkstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todouno.hulkstore.model.Producto;

import io.swagger.annotations.Api;

@Api(value = "/producto")
@RestController
@RequestMapping(value = "/producto")
public class RESTControllerProducto extends RESTControllerGeneric<Producto>{



}
