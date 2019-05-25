package dev.felipeaguiar.financeiro.domain.lancamento;

import java.util.List;

import org.springframework.data.domain.Pageable;

import dev.felipeaguiar.financeiro.domain.lancamento.filter.LancamentoFilter;

public interface LancamentoRepositoryCustom {
	
	public List<Lancamento> filtrar(LancamentoFilter filter, Pageable pageable);
	public Long count(LancamentoFilter filter);

}
