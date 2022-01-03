package trilha.back.financys.mappers;

import org.mapstruct.Mapper;
import trilha.back.financys.dtos.LancamentoDTO;
import trilha.back.financys.entity.LancamentoEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LancamentoMapper {

    LancamentoDTO toLancamento(LancamentoEntity lancamentoEntity);

    LancamentoEntity toDTO(LancamentoDTO lancamentoDTO);

    List<LancamentoDTO> toListLancamento(List<LancamentoEntity> lancamentoEntity);









}
