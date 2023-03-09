package com.springbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapp.dto.UsuarioDTO;
import com.springbootapp.model.Usuario;
import com.springbootapp.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		return usuarioService.saveUsuario(usuarioDTO);
	}

	@GetMapping("/list")
	public ResponseEntity<ResponseEntity<List<Usuario>>> listUsuarios() {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listUsuarios());
	}

	@PutMapping("/updatebyid/{id}")
	public void updateUsuario(@PathVariable("id") Long id, @RequestBody UsuarioDTO usuarioDTO) {
		usuarioService.updateUsuario(id, usuarioDTO);
	}

	@GetMapping("/searchbyid/{id}")
	public ResponseEntity<Usuario> searchUsuarioById(@PathVariable("id") Long id) {
		return usuarioService.searchUsuarioById(id);

	}

	@DeleteMapping("/inativarbyid/{id}")
	public void inativarUsuarioById(@PathVariable("id") Long id) {
		usuarioService.inativarUsuarioById(id);
	}

	@DeleteMapping("/deletebyid/{id}")
	public void deleteUsuarioById(@PathVariable("id") Long id) {
		usuarioService.deleteUsuarioById(id);
	}

}