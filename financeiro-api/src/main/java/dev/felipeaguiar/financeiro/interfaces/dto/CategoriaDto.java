package dev.felipeaguiar.financeiro.interfaces.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CategoriaDto {

	private Long id;

	private Long version;

	@NotBlank
	@Size(min = 3, max = 50)
	private String nome;

}
