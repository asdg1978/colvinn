package com.todouno.hulkstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todouno.hulkstore.model.Compra;

import io.swagger.annotations.Api;

@Api(value = "/compra")
@RestController
@RequestMapping(value = "/compra")
public class RESTControllerCompra extends RESTControllerGeneric<Compra>{






}
