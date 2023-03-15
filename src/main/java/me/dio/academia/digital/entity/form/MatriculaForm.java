package me.dio.academia.digital.entity.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
public class MatriculaForm {

	@NotNull
	@Positive
	private Long alunoId;

}
