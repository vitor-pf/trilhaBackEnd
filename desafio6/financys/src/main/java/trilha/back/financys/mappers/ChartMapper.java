package trilha.back.financys.mappers;


import org.mapstruct.Mapper;
import trilha.back.financys.dtos.ChartDTO;
import trilha.back.financys.model.Lancamento;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChartMapper {

    ChartDTO toChart(Lancamento lancamento);

    Lancamento toDTO(ChartDTO chartDTO);

    List<ChartDTO> toListChart(List<Lancamento> lancamento);



}
