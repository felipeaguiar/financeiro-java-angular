package dev.felipeaguiar.financeiro.interfaces.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.fge.jsonpatch.JsonPatch;

import dev.felipeaguiar.financeiro.application.pessoa.PessoaService;
import dev.felipeaguiar.financeiro.domain.pessoa.Pessoa;
import dev.felipeaguiar.financeiro.interfaces.dto.PessoaDto;
import dev.felipeaguiar.financeiro.interfaces.map.PessoaMapper;
import dev.felipeaguiar.financeiro.interfaces.resource.util.ResourceHelper;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private ResourceHelper helper;

	@Autowired
	private PessoaMapper mapper;

	@GetMapping
	public Page<PessoaDto> listar(Pageable pageable) {
		List<PessoaDto> pessoas = pessoaService.todas().stream()
			.map(mapper::toDto)
			.collect(Collectors.toList());

		Long total = pessoaService.count();

		return new PageImpl<>(pessoas, pageable, total);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PessoaDto> buscarPorId(@PathVariable Long id) {
		Pessoa pessoa = pessoaService.buscarPorId(id);
		return ResponseEntity.ok(mapper.toDto(pessoa));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		pessoaService.remover(id);
	}

	@PostMapping
	public ResponseEntity<PessoaDto> salvar(@Valid @RequestBody PessoaDto pessoaDto) {
		Pessoa pessoa = mapper.fromDto(pessoaDto);
		Pessoa pessoaSalva = pessoaService.salvar(pessoa);

		PessoaDto pessoaDtoSalva = mapper.toDto(pessoaSalva);

		URI uri = helper.getUriOf(pessoaDtoSalva.getId());
		return ResponseEntity.created(uri).body(pessoaDtoSalva);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PessoaDto> atualizar(@PathVariable Long id, @Valid @RequestBody PessoaDto pessoaDto) {
		Pessoa pessoa = mapper.fromDto(pessoaDto);
		Pessoa pessoaSalva = pessoaService.atualizar(id, pessoa);

		PessoaDto pessoaDtoSalva = mapper.toDto(pessoaSalva);

		return ResponseEntity.ok(pessoaDtoSalva);
	}

	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void patch(@PathVariable Long id, @RequestBody JsonPatch patch) throws MethodArgumentNotValidException {
		PessoaDto pessoaDto = mapper.toDto(pessoaService.buscarPorId(id));

		pessoaDto = helper.applyPatch(patch, pessoaDto, PessoaDto.class);

		Pessoa pessoa = mapper.fromDto(pessoaDto);
		pessoaService.atualizar(id, pessoa);

	}

}
