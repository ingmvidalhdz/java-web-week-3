package com.curso.junit;

import java.util.Objects;

public class UsuarioDto {
	final Long id;
	final String nombre;
	
	public UsuarioDto(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null|| getClass() != o.getClass()) return false;
		UsuarioDto that = (UsuarioDto) o;
		return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre);
	}
	
}
