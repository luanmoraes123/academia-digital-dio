package me.dio.academia.digital.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IAlunoService;
import me.dio.academia.digital.service.IMatriculaService;

@Service
public class MatriculaServiceImpl implements IMatriculaService{
	
	@Autowired
	private MatriculaRepository repository;
	
	@Autowired
	private IAlunoService alunoService;

	@Override
	public Matricula create(MatriculaForm form) {
		Matricula matricula = new Matricula();
		Aluno aluno = alunoService.get(form.getAlunoId());
		matricula.setAluno(aluno);
		return repository.save(matricula);
	}

	@Override
	public Matricula get(Long id) {
		Optional<Matricula> matricula = repository.findById(id);
		
		if(matricula.isPresent()) {
			return matricula.get();
		}else {
			throw new RuntimeException("Entidade não encontrada.");
		}
	}

	@Override
	public List<Matricula> getAll() {
		
		return repository.findAll();
	}

	@Override
	public void delete(Long id) {
		Matricula matricula = get(id);
		repository.delete(matricula);
	}

}
