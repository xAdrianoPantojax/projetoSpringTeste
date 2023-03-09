package com.springbootapp.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.springbootapp.dto.UsuarioDTO;
import com.springbootapp.model.Usuario;
import com.springbootapp.repository.UsuarioRepository;

@SpringBootTest
public class UsuarioServiceTest {

	@Autowired
	private UsuarioService usuarioService;

	@MockBean
	private UsuarioRepository usuarioRepository;

	@Test
	void testSaveUsuario() {
		
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setDadosCep("1234567");
		usuarioDTO.setDescricaoExercicioCargo("teste");
		usuarioDTO.setEnderecoEmail("teste");
		usuarioDTO.setNomeUsuario("teste");
		usuarioDTO.setNumeroCelular("teste");
		
		Usuario usuario = new Usuario();
		usuario.setDadosCep(usuarioDTO.getDadosCep());
		usuario.setDescricaoExercicioCargo(usuarioDTO.getDescricaoExercicioCargo());
		usuario.setEnderecoEmail(usuarioDTO.getEnderecoEmail());
		usuario.setNomeUsuario(usuarioDTO.getNomeUsuario());
		usuario.setId(1);
		usuario.setNumeroCelular(usuarioDTO.getNumeroCelular());
		usuario.setSituacao(true);

		doReturn(usuario).when(usuarioRepository).save(any());

		
		ResponseEntity<Object> returnedUsuario = usuarioService.saveUsuario(usuarioDTO);
		
		Assertions.assertNotNull(returnedUsuario);
		Assertions.assertEquals(usuario, returnedUsuario.getBody());

	}

}