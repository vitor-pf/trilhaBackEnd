package trilha.back.financys.mappers;

import org.mapstruct.Mapper;
import trilha.back.financys.dtos.CategoriaDTO;
import trilha.back.financys.entity.CategoriaEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaDTO toCategoriaDTO(CategoriaEntity categoriaEntity);

    CategoriaEntity toDTO(CategoriaDTO categoriaDTO);

    List<CategoriaDTO> toListCategoriaDTO(List<CategoriaEntity> categoriaEntity);









}
