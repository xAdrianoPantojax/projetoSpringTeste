package com.springbootapp.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootapp.dto.UsuarioDTO;
import com.springbootapp.model.Usuario;
import com.springbootapp.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public ResponseEntity<Object> saveUsuario(UsuarioDTO usuarioDTO) {
		var usuario = new Usuario();
		BeanUtils.copyProperties(usuarioDTO, usuario);
		usuario.setSituacao(true);
		usuario.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));

	}

	public ResponseEntity<List<Usuario>> listUsuarios() {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll());
	}

	public void updateUsuario(Long id, UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioRepository.findById(id).get();
		BeanUtils.copyProperties(usuarioDTO, usuario);
		usuarioRepository.save(usuario);
	}

	public ResponseEntity<Usuario> searchUsuarioById(Long id) {
		Optional<Usuario> usuarioDados = usuarioRepository.findById(id);
		if (usuarioDados.isPresent()) {
			return new ResponseEntity<>(usuarioDados.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	public void deleteUsuarioById(Long id) {
		usuarioRepository.deleteById(id);

	}

	public void inativarUsuarioById(Long id) {
		Usuario usuario = usuarioRepository.findById(id).get();
		usuario.setSituacao(false);
		usuarioRepository.save(usuario);
	}

}