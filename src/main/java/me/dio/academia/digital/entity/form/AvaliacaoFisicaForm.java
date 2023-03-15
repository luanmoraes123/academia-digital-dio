package me.dio.academia.digital.entity.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AvaliacaoFisicaForm {

	@NotBlank
	private Long alunoId;

	@NotBlank
	private double peso;

	@NotBlank
	private double altura;
}
