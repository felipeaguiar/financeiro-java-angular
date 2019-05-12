package dev.felipeaguiar.financeiro.interfaces.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.felipeaguiar.financeiro.application.categoria.CategoriaService;
import dev.felipeaguiar.financeiro.domain.lancamento.Categoria;
import dev.felipeaguiar.financeiro.interfaces.dto.CategoriaDto;
import dev.felipeaguiar.financeiro.interfaces.map.CategoriaMapper;
import dev.felipeaguiar.financeiro.interfaces.resource.util.ResourceHelper;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private ResourceHelper helper;

	@Autowired
	private CategoriaMapper mapper;

	@GetMapping
	public List<CategoriaDto> listar() {
		return categoriaService.todas().stream()
			.map(mapper::toDto)
			.collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDto> buscarPorId(@PathVariable Long id) {
		Categoria categoria = categoriaService.buscarPorId(id);
		return ResponseEntity.ok(mapper.toDto(categoria));
	}

	@PostMapping
	public ResponseEntity<CategoriaDto> salvar(@Valid @RequestBody CategoriaDto categoriaDto) {
		Categoria categoria = mapper.fomDto(categoriaDto);
		categoria = categoriaService.salvar(categoria);

		CategoriaDto categoriaDtoSalva = mapper.toDto(categoria);

		URI uri = helper.getUriOf(categoriaDtoSalva.getId());
		return ResponseEntity.created(uri).body(categoriaDtoSalva);
	}

}
