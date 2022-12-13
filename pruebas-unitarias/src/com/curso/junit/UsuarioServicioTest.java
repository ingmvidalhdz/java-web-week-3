package com.curso.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioServicioTest {
	
	private UsuarioServicio usuarioServicio = new UsuarioServicio();
	
	@BeforeEach
	public void setUp() {
		usuarioServicio = new UsuarioServicio();
		usuarioServicio.crearUsuario(0L, "Usuario Principal");
		usuarioServicio.crearUsuario(2L, "Usuario segundo");
	}
	
	@Test
	public void test1() {
		UsuarioDto esperado = new UsuarioDto(1L, "Prueba");
		UsuarioServicio usuarioServicio = new UsuarioServicio();
		final UsuarioDto resultado = usuarioServicio.crearUsuario(1L,"Prueba");
		Assertions.assertEquals(esperado.id, resultado.id);
		Assertions.assertEquals(esperado.nombre, resultado.nombre);
		Assertions.assertEquals(esperado, resultado);
	}
	
	@Test
	public void test2() {
		UsuarioDto esperado = new UsuarioDto(2L, "Pruebas");
		UsuarioServicio usuarioServicio = new UsuarioServicio();
		final UsuarioDto resultado = usuarioServicio.crearUsuario(1L,"Prueba");
		Assertions.assertNotEquals(esperado.id, resultado.id);
		Assertions.assertNotEquals(esperado.nombre, resultado.nombre);
		Assertions.assertNotEquals(esperado, resultado);
	}
	
	
	@Test
	public void test4() {
		UsuarioDto esperado = new UsuarioDto(2L, "Pruebas");
		UsuarioServicio usuarioServicio = new UsuarioServicio();
		
		usuarioServicio.crearUsuario(1L, "Nombre");
		
		final UsuarioDto resultado = usuarioServicio.obtenerUsuario(1L);
		Assertions.assertNotEquals(esperado, resultado);
	}
	
}
