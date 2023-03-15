package me.dio.academia.digital.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAlunoService;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService{
	
	@Autowired
	private AvaliacaoFisicaRepository repository;
	
	@Autowired
	private IAlunoService alunoService;

	@Override
	public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
		AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
		Aluno aluno = alunoService.get(form.getAlunoId());
		avaliacaoFisica.setAluno(aluno);
		avaliacaoFisica.setAltura(form.getAltura());
		avaliacaoFisica.setPeso(form.getPeso());
		
		return repository.save(avaliacaoFisica);
	}

	@Override
	public AvaliacaoFisica get(Long id) {
		Optional<AvaliacaoFisica> avaliacao = repository.findById(id);
		
		if(avaliacao.isPresent()) {
			return avaliacao.get();
		}else {
			throw new RuntimeException("Entidade não econtrada");
		}
	}

	@Override
	public List<AvaliacaoFisica> getAll() {	
		return repository.findAll();
	}

	@Override
	public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
		AvaliacaoFisica avaliacao = get(id);
		avaliacao.setAltura(formUpdate.getAltura());
		avaliacao.setPeso(formUpdate.getPeso());
		return null;
	}

	@Override
	public void delete(Long id) {
		AvaliacaoFisica avaliacao = get(id);
		repository.delete(avaliacao);
	}

}
