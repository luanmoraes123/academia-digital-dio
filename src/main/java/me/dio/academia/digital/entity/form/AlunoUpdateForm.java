package me.dio.academia.digital.entity.form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AlunoUpdateForm {

	@NotBlank
	private String nome;

	@NotBlank
	private String bairro;

	@NotBlank
	private LocalDate dataDeNascimento;
}
