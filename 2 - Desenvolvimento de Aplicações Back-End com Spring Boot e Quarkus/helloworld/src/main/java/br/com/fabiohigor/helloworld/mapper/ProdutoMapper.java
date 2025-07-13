// ProdutoMapper.java
package br.com.fabiohigor.helloworld.mapper;

import br.com.fabiohigor.helloworld.dto.ProdutoDTO;
import br.com.fabiohigor.helloworld.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoMapper {
    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    Produto toEntity(ProdutoDTO dto);
    ProdutoDTO toDTO(Produto entity);
}