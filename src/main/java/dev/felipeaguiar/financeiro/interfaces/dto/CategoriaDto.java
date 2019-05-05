package dev.felipeaguiar.financeiro.interfaces.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CategoriaDto {

	@NotNull
	private Long id;

	@NotNull
	private Long version;

	@NotNull
	@Size(min = 3, max = 50)
	private String nome;

}
