package dev.felipeaguiar.financeiro.domain.lancamento;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import dev.felipeaguiar.financeiro.domain.pessoa.Pessoa;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class Lancamento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	private Long id;

	@Version
	@Getter
	private Long version;

	@Column(length = 50, nullable = false)
	@NonNull
	@Getter @Setter
	private String descricao;

	@Column(name = "data_vencimento", nullable = false)
	@NonNull
	@Getter @Setter
	private LocalDate dataVencimento;

	@Column(name = "data_pagamento")
	@Getter @Setter
	private LocalDate dataPagamento;

	@Column(nullable = false)
	@NonNull
	@Getter @Setter
	private BigDecimal valor;

	@Column(length = 100)
	@Getter @Setter
	private String observacao;

	@Enumerated
	@Column(nullable = false)
	@NonNull
	@Getter @Setter
	private TipoLancamento tipo;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_categoria")
	@NonNull
	@Getter @Setter
	private Categoria categoria;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_pessoa")
	@NonNull
	@Getter @Setter
	private Pessoa pessoa;

}
