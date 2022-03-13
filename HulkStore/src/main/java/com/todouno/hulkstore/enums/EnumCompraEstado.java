package com.todouno.hulkstore.enums;

public enum EnumCompraEstado {

	PAGADO(Long.valueOf(1), "P","Ingreso"),
	PENDIENTE(Long.valueOf(2), "PE","Pendiente de Pago");

	private Long id;
	private String name;
	private String descripcion;

	private EnumCompraEstado(Long id,String name,String descripcion){
		this.id = id;
		this.name = name;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



}
