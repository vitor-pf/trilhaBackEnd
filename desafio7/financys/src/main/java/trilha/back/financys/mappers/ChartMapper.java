package trilha.back.financys.mappers;


import org.mapstruct.Mapper;
import trilha.back.financys.dtos.ChartDTO;
import trilha.back.financys.entity.LancamentoEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChartMapper {

    ChartDTO toChart(LancamentoEntity lancamentoEntity);

    LancamentoEntity toDTO(ChartDTO chartDTO);

    List<ChartDTO> toListChart(List<LancamentoEntity> lancamentoEntity);



}
