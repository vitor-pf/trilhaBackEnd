package trilha.back.financys.mappers;

import org.mapstruct.Mapper;
import trilha.back.financys.dtos.CategoriaDTO;
import trilha.back.financys.model.Categoria;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaDTO toCategoriaDTO(Categoria categoria);

    Categoria toDTO(CategoriaDTO categoriaDTO);

    List<CategoriaDTO> toListCategoriaDTO(List<Categoria> categoria);









}
