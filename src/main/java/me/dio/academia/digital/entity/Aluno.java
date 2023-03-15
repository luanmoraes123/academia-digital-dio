package me.dio.academia.digital.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_alunos")
@JsonIgnoreProperties({"hibernateLazeInitializer", "handler"})
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;

	@NotBlank
	@Column(unique = true)
	private String cpf;

	private String bairro;

	private LocalDate dataDeNascimento;

	@OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
	
}
