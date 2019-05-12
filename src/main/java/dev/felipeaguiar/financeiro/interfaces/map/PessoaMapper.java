package dev.felipeaguiar.financeiro.interfaces.map;

import org.springframework.stereotype.Component;

import dev.felipeaguiar.financeiro.domain.pessoa.Endereco;
import dev.felipeaguiar.financeiro.domain.pessoa.Pessoa;
import dev.felipeaguiar.financeiro.interfaces.dto.PessoaDto;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class PessoaMapper {

	private MapperFacade mapper;
	
	public PessoaMapper() {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();		
		mapper = mapperFactory.getMapperFacade();
	}
	
	public PessoaDto toDto(Pessoa pessoa) {
		return mapper.map(pessoa, PessoaDto.class);
	}

	public Pessoa fomDto(PessoaDto pessoaDto) {
		Pessoa pessoa = new Pessoa(pessoaDto.getNome(), pessoaDto.getAtivo());
		
		if (pessoaDto.getEndereco() != null) {
			Endereco endereco = new Endereco();
			
			endereco.setBairro(pessoaDto.getEndereco().getBairro());
			endereco.setCep(pessoaDto.getEndereco().getCep());
			endereco.setCidade(pessoaDto.getEndereco().getCidade());
			endereco.setComplemento(pessoaDto.getEndereco().getComplemento());
			endereco.setEstado(pessoaDto.getEndereco().getEstado());
			endereco.setLogradouro(pessoaDto.getEndereco().getLogradouro());
			endereco.setNumero(pessoaDto.getEndereco().getNumero());
			
			pessoa.setEndereco(endereco);
		}
		return pessoa;
	}
	
}
