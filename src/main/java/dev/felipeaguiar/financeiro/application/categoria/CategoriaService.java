package dev.felipeaguiar.financeiro.application.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import dev.felipeaguiar.financeiro.domain.lancamento.Categoria;
import dev.felipeaguiar.financeiro.domain.lancamento.CategoriaRepository;

@Service
public class CategoriaService {

	private CategoriaRepository categoriaRepository;
	
	@Autowired
	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	public List<Categoria> todas() {
		return categoriaRepository.findAll();
	}

	public Categoria buscarPorId(Long id) {
		return categoriaRepository.findById(id)
			.orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	public Categoria salvar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

}
