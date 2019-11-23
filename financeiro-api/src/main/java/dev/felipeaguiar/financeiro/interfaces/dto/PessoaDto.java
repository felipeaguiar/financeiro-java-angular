package dev.felipeaguiar.financeiro.interfaces.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PessoaDto {

	private Long id;

	private Long version;

	@NotBlank
	@Size(min = 3, max = 50)
	private String nome;

	@NotNull
	private Boolean ativo;

	@Valid
	private EnderecoDto endereco;

}
