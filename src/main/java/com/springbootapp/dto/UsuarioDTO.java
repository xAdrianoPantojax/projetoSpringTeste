package com.springbootapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioDTO {

	private String nomeUsuario;
	private String numeroCelular;
	private String enderecoEmail;
	private String descricaoExercicioCargo;
	private String dadosCep;
	
}