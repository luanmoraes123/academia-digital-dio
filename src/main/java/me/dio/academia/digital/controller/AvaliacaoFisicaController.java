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

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {
	
	@Autowired
	private IAvaliacaoFisicaService service;
	
	@GetMapping
	public List<AvaliacaoFisica> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public AvaliacaoFisica getAvaliacao(@PathVariable Long id){
		return service.get(id);
	}
	
	@PostMapping
	public AvaliacaoFisica createAvaliacao(@Valid @RequestBody AvaliacaoFisicaForm form) {
		return service.create(form);
	}
	
	@PutMapping("/{id}")
	public AvaliacaoFisica updateAvaliacao(@PathVariable Long id,@Valid @RequestBody AvaliacaoFisicaUpdateForm form) {
		return service.update(id, form);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAvaliacao(@PathVariable Long id) {
		service.delete(id);
	}
	
}
