package dev.felipeaguiar.financeiro.application.pessoa;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import dev.felipeaguiar.financeiro.domain.pessoa.Pessoa;
import dev.felipeaguiar.financeiro.domain.pessoa.PessoaRepository;

@Service
public class PessoaService {

	private PessoaRepository pessoaRepository;
	
	@Autowired
	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	public List<Pessoa> todas() {
		return pessoaRepository.findAll();
	}
	
	public Long count() {
		return pessoaRepository.count();
	}

	public Pessoa buscarPorId(Long id) {
		return pessoaRepository.findById(id)
			.orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public void remover(Long id) {
		pessoaRepository.deleteById(id);
	}
	
	public Pessoa atualizar(Long id, Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPorId(id);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "id");
		return pessoaRepository.save(pessoaSalva);
	}

}
