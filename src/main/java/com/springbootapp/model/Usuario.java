package com.springbootapp.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Integer id;

	@Column(name = "SITUACAO")
	private boolean situacao;

	@Column(name = "NM_USUARIO")
	private String nomeUsuario;

	@Column(name = "NM_CELULAR")
	private String numeroCelular;

	@Column(name = "EN_EMAIL")
	private String enderecoEmail;

	@Column(name = "DS_EXERCICO_CARGO")
	private String descricaoExercicioCargo;

	@Column(name = "DT_INCLUSAO")
	private LocalDateTime dataInclusao;

	@Column(name = "DD_CEP")
	private String dadosCep;

}
