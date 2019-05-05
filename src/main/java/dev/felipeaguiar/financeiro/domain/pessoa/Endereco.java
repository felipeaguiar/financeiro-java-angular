package dev.felipeaguiar.financeiro.domain.pessoa;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@ToString
@EqualsAndHashCode
public class Endereco {

	@Column(length = 30)
	@Getter @Setter
	private String logradouro;

	@Column(length = 30)
	@Getter @Setter
	private String numero;

	@Column(length = 30)
	@Getter @Setter
	private String complemento;

	@Column(length = 30)
	@Getter @Setter
	private String bairro;

	@Column(length = 30)
	@Getter @Setter
	private String cep;

	@Column(length = 30)
	@Getter @Setter
	private String cidade;

	@Column(length = 30)
	@Getter @Setter
	private String estado;

}
