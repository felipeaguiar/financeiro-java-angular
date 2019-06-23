package dev.felipeaguiar.financeiro.application.lancamento;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.felipeaguiar.financeiro.domain.lancamento.Lancamento;
import dev.felipeaguiar.financeiro.domain.lancamento.LancamentoRepository;
import dev.felipeaguiar.financeiro.domain.lancamento.LancamentoResumo;
import dev.felipeaguiar.financeiro.domain.lancamento.filter.LancamentoFilter;

@Service
public class LancamentoService {

	private LancamentoRepository lancamentoRepository;

	@Autowired
	public LancamentoService(LancamentoRepository lancamentoRepository) {
		this.lancamentoRepository = lancamentoRepository;
	}

	public List<Lancamento> filtrar(LancamentoFilter filter, Pageable pageable) {
		return lancamentoRepository.filtrar(filter, pageable);
	}

	public List<LancamentoResumo> resumir(LancamentoFilter filter, Pageable pageable) {
		return lancamentoRepository.resumir(filter, pageable);
	}


	public Lancamento buscarPorId(Long id) {
		return lancamentoRepository.findById(id)
			.orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	public Lancamento salvar(Lancamento lancamento) {

		if (lancamento.getPessoa().isInativo()) {
			throw new PessoaInativaException();
		}

		return lancamentoRepository.save(lancamento);
	}

	public void remover(Long id) {
		lancamentoRepository.deleteById(id);
	}

	public Lancamento atualizar(Long id, Lancamento lancamento) {
		Lancamento lancamentoSalvo = buscarPorId(id);
		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "id");
		return lancamentoRepository.save(lancamentoSalvo);
	}

	public Long count(LancamentoFilter filter) {
		return lancamentoRepository.count(filter);
	}

}
