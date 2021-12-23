package trilha.back.financys.mappers;

import org.mapstruct.Mapper;
import trilha.back.financys.dtos.LancamentoDTO;
import trilha.back.financys.model.Lancamento;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LancamentoMapper {

    LancamentoDTO toLancamento(Lancamento lancamento);

    Lancamento toDTO(LancamentoDTO lancamentoDTO);

    List<LancamentoDTO> toListLancamento(List<Lancamento> lancamento);









}
