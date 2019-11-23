package dev.felipeaguiar.financeiro.interfaces.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import dev.felipeaguiar.financeiro.application.categoria.CategoriaService;
import dev.felipeaguiar.financeiro.application.pessoa.PessoaService;
import dev.felipeaguiar.financeiro.domain.lancamento.Categoria;
import dev.felipeaguiar.financeiro.domain.lancamento.Lancamento;
import dev.felipeaguiar.financeiro.domain.pessoa.Pessoa;
import dev.felipeaguiar.financeiro.interfaces.dto.LancamentoDto;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class LancamentoMapper {

	private MapperFacade mapper;
	
	private CategoriaService categoriaService;
	private PessoaService pessoaService;
	
	@Autowired
	public LancamentoMapper(CategoriaService categoriaService, PessoaService pessoaService) {
		this.categoriaService = categoriaService;
		this.pessoaService = pessoaService;
		
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();		
		mapper = mapperFactory.getMapperFacade();
	}
	
	public LancamentoDto toDto(Lancamento lancamento) {
		return mapper.map(lancamento, LancamentoDto.class);
	}

	public Lancamento fromDto(LancamentoDto lancamentoDto) {
		
		Categoria categoria = null;
		Pessoa pessoa = null;
		
		try {
			categoria = categoriaService.buscarPorId(lancamentoDto.getCategoria().getId());
			pessoa = pessoaService.buscarPorId(lancamentoDto.getPessoa().getId());
		} catch (Exception e) {
			throw new DataIntegrityViolationException(this.getClass().getSimpleName(), e);
		}
		
		Lancamento lancamento = new Lancamento(
			lancamentoDto.getDescricao(),
			lancamentoDto.getDataVencimento(),
			lancamentoDto.getValor(),
			lancamentoDto.getTipo(),
			categoria,
			pessoa
		);

		lancamento.setDataPagamento(lancamentoDto.getDataPagamento());
		lancamento.setObservacao(lancamentoDto.getObservacao());
		
		return lancamento;
	}
	
}
