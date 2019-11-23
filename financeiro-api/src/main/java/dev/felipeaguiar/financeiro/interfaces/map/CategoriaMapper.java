package dev.felipeaguiar.financeiro.interfaces.map;

import org.springframework.stereotype.Component;

import dev.felipeaguiar.financeiro.domain.lancamento.Categoria;
import dev.felipeaguiar.financeiro.interfaces.dto.CategoriaDto;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class CategoriaMapper {
	
	private MapperFacade mapper;
	
	public CategoriaMapper() {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();		
		mapper = mapperFactory.getMapperFacade();
	}
	
	public CategoriaDto toDto(Categoria categoria) {
		return mapper.map(categoria, CategoriaDto.class);
	}

	public Categoria fromDto(CategoriaDto categoriaDto) {
		return new Categoria(categoriaDto.getNome());
	}

}
