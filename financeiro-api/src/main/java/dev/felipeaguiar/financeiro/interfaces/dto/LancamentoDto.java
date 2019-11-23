package dev.felipeaguiar.financeiro.interfaces.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import dev.felipeaguiar.financeiro.domain.lancamento.TipoLancamento;
import lombok.Data;

@Data
public class LancamentoDto {

	private Long id;

	private Long version;

	@NotBlank
	@Size(min = 3, max = 50)
	private String descricao;

	@NotNull
	private LocalDate dataVencimento;

	private LocalDate dataPagamento;

	@NotNull
	private BigDecimal valor;

	@Size(min = 3, max = 100)
	private String observacao;

	private PessoaDto pessoa;

	private TipoLancamento tipo;

	private CategoriaDto categoria;

}
