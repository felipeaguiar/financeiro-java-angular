package dev.felipeaguiar.financeiro.domain.lancamento.filter;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LancamentoFilter {

	private String descricao;

	private LocalDate dataVencimentoDe;

	private LocalDate dataVencimentoAte;

}
