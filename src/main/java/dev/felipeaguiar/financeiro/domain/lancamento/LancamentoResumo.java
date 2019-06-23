package dev.felipeaguiar.financeiro.domain.lancamento;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LancamentoResumo {

	private Long id;

	private String descricao;

	private LocalDate dataVencimento;

	private LocalDate dataPagamento;

	private BigDecimal valor;

	private String categoria;

	private String pessoa;

	private TipoLancamento tipo;

}
