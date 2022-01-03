package trilha.back.financys.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import trilha.back.financys.dtos.ChartDTO;
import trilha.back.financys.dtos.LancamentoDTO;
import trilha.back.financys.entity.CategoriaEntity;
import trilha.back.financys.entity.LancamentoEntity;
import trilha.back.financys.repository.CategoriaRepository;
import trilha.back.financys.repository.LancamentoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LancamentoService {
    @Autowired
    private LancamentoRepository lancamentoRepository;
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ModelMapper modelMapper;
    public LancamentoService(LancamentoRepository lancamentoRepository, ModelMapper modelMapper) {
        this.lancamentoRepository = lancamentoRepository;
        this.modelMapper = modelMapper;
    }
    public boolean validateCategoryById(long idCategory) {
        if(!categoriaRepository.findById(idCategory).isEmpty()){
            return true;
        }
        return false;
    }
    public List<ChartDTO> grafico() {
        List<ChartDTO> lists= new ArrayList<ChartDTO>();
        List<CategoriaEntity> categoriaEntities = categoriaRepository.findAll();

        for (CategoriaEntity categoriaEntity : categoriaEntities){
            ChartDTO chartDTO = new ChartDTO();
            chartDTO.setName(categoriaEntity.getNameCategoria());
            chartDTO.setTotal(0.0);
            for (LancamentoEntity lancamentoEntity : categoriaEntity.getLancamentoEntity()){
                chartDTO.setTotal(lancamentoEntity.getAmount()+chartDTO.getTotal());
            }
            lists.add(chartDTO);
        }
        return lists;
    }
    public List<?> graficoTeste() {
        return lancamentoRepository.findAll().stream().collect(Collectors.toList());
    }

    public ResponseEntity<LancamentoDTO> create(LancamentoEntity body, BindingResult result){
        if(validateCategoryById(body.getCategory().getId()) && (!result.hasErrors())){
            return ResponseEntity.status(HttpStatus.OK).body(maptoEntity(lancamentoRepository.save(body)));
        }
        return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<LancamentoDTO>> readAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(maptoListEntity(lancamentoRepository.findAll()));
    }

    public ResponseEntity<LancamentoDTO> readById(long id){
        return ResponseEntity.status(HttpStatus.OK).body(maptoEntity(lancamentoRepository.findById(id).get()));
    }

    public ResponseEntity<LancamentoDTO> update(Long id, LancamentoEntity body){
        if (Objects.equals(body.getId(), lancamentoRepository.getById(id).getId()) ) {
            return ResponseEntity.status(HttpStatus.OK).body(maptoEntity(lancamentoRepository.save(body)));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(maptoEntity(body));
    }

    public void deleteById(long id){
        lancamentoRepository.deleteById(id);
    }



    private LancamentoEntity mapToDto(LancamentoDTO dto) {
        return modelMapper.map(dto, LancamentoEntity.class);
    }
    private LancamentoDTO maptoEntity(LancamentoEntity entity) {
        return modelMapper.map(entity, LancamentoDTO.class);
    }
    private List<LancamentoDTO> maptoListEntity(List<LancamentoEntity> entity) {
        return (List<LancamentoDTO>) modelMapper.map(entity, new TypeToken<List<LancamentoDTO>>(){}.getType());
    }
}