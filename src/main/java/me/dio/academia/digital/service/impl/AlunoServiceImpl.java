package me.dio.academia.digital.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService{
	
	@Autowired
	private AlunoRepository repository;

	@Override
	public Aluno create(AlunoForm form) {
		Aluno aluno = new Aluno();
		aluno.setBairro(form.getBairro());
		aluno.setCpf(form.getCpf());
		aluno.setDataDeNascimento(form.getDataDeNascimento());
		aluno.setNome(form.getNome());
		return repository.save(aluno);
	}

	@Override
	public Aluno get(Long id) {
		Optional<Aluno> aluno = repository.findById(id);
		
		if(aluno.isPresent()) {
			return aluno.get();
		}else {
			throw new RuntimeException("Entidade não encontrada");
		}
	}

	@Override
	public List<Aluno> getAll() {
		return repository.findAll();
	}

	@Override
	public Aluno update(Long id, AlunoUpdateForm formUpdate) {
		Aluno aluno = get(id);
		aluno.setNome(formUpdate.getNome());
		aluno.setBairro(formUpdate.getBairro());
		aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());
		return repository.save(aluno);
	}

	@Override
	public void delete(Long id) {
		Aluno aluno = get(id);
		repository.delete(aluno);	
	}

	@Override
	public List<AvaliacaoFisica> getAllAvalaicaoFisica(Long id) {
		Aluno aluno = get(id);	
		return aluno.getAvaliacoes();
	}

}
