package me.dio.academia.digital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.IAlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private IAlunoService service;
	
	@GetMapping
	public List<Aluno> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public Aluno getOne(@PathVariable Long id){
		return service.get(id);
	}
	
	@GetMapping("/{id}/avaliacoes")
	public List<AvaliacaoFisica> obterAvaliacoes(@PathVariable Long id){
		return service.getAllAvalaicaoFisica(id);
	}
	
	@PostMapping
	public Aluno createAluno(@Valid @RequestBody AlunoForm alunoForm) {
		return service.create(alunoForm);
	}
	
	@PutMapping("/{id}")
	public Aluno updateAluno(@PathVariable Long id,@Valid @RequestBody AlunoUpdateForm form) {
		return service.update(id, form);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAluno(@PathVariable Long id) {
		service.delete(id);
	}
}
