package com.todouno.hulkstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todouno.hulkstore.model.Movimiento;

import io.swagger.annotations.Api;

@Api(value = "/movimiento")
@RestController
@RequestMapping(value = "/movimiento")
public class RESTControllerMovimiento extends RESTControllerGeneric<Movimiento>{





}
