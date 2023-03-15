package me.dio.academia.digital.entity.form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
public class AlunoForm {

	@NotBlank
	@Size(min = 3, max = 50)
	private String nome;

	@NotBlank
	@CPF
	private String cpf;

	@NotBlank
	@Size(min = 3, max = 50)
	private String bairro;

	@NotNull
	@Past
	private LocalDate dataDeNascimento;
}
