package dev.felipeaguiar.financeiro.interfaces.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.felipeaguiar.financeiro.application.categoria.CategoriaService;
import dev.felipeaguiar.financeiro.domain.lancamento.Categoria;
import dev.felipeaguiar.financeiro.interfaces.dto.CategoriaDto;
import dev.felipeaguiar.financeiro.interfaces.map.CategoriaMapper;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private CategoriaMapper categoriaMapper;
	
	@GetMapping
	public List<CategoriaDto> listar() {
		return categoriaService.todas().stream()
			.map(categoriaMapper::toDto)
			.collect(Collectors.toList());
	}

}
