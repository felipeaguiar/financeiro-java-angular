package dev.felipeaguiar.financeiro.interfaces.dto;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class EnderecoDto {

	@Size(min = 3, max = 30)
	private String logradouro;

	@Size(min = 3, max = 30)
	private String numero;

	@Size(min = 3, max = 30)
	private String complemento;

	@Size(min = 3, max = 30)
	private String bairro;

	@Size(min = 3, max = 30)
	private String cep;

	@Size(min = 3, max = 30)
	private String cidade;

	@Size(min = 2, max = 2)
	private String estado;

}
