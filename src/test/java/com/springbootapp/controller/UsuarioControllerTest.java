package com.springbootapp.controller;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springbootapp.model.Usuario;

@SpringBootTest
public class UsuarioControllerTest {
	
	@Autowired
	private UsuarioController usuarioController;
	
	private Usuario usuario;
	
	@BeforeEach
	public void init() {
		usuario = mock(Usuario.class);
	}
	
	@Test
	public void testSaveUsuario() {
		
		Usuario usuario = new Usuario();
		usuario.setNomeUsuario("teste");
		
		
		
//		usuarioController.saveUsuario(usuario);
		
	
	}
	
}