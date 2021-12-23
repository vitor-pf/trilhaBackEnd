package trilha.back.financys.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.financys.dtos.ChartDTO;
import trilha.back.financys.dtos.LancamentoDTO;
import trilha.back.financys.mappers.LancamentoMapper;
import trilha.back.financys.model.Categoria;
import trilha.back.financys.model.Lancamento;
import trilha.back.financys.repository.CategoriaRepository;
import trilha.back.financys.repository.LancamentoRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LancamentoService {
    @Autowired
    private LancamentoRepository lancamentoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    private final LancamentoMapper mapper;

    public boolean validateCategoryById(long idCategory) {
        if(!categoriaRepository.findById(idCategory).isEmpty()){
            return true;
        }
        return false;
    }
    public List<ChartDTO> grafico() {
        List<ChartDTO> lists= new ArrayList<ChartDTO>();
        List<Categoria> categorias = categoriaRepository.findAll();

        for (Categoria categoria : categorias){
            ChartDTO chartDTO = new ChartDTO();
            chartDTO.setName(categoria.getName());
            chartDTO.setTotal(0.0);
            for (Lancamento lancamento : categoria.getLancamento()){
                chartDTO.setTotal(lancamento.getAmount()+chartDTO.getTotal());
            }
            lists.add(chartDTO);
        }
        return lists;
    }

    public LancamentoDTO save(Lancamento lancamento){
        Lancamento result = lancamentoRepository.save(lancamento);
        return mapper.toLancamento(result);
    }
    public List<LancamentoDTO> findAll(){
        List<Lancamento> lancamento = lancamentoRepository.findAll();
        return mapper.toListLancamento(lancamento);
    }
    public LancamentoDTO findById(long id){
        Lancamento lancamento = lancamentoRepository.findById(id).get();
        return mapper.toLancamento(lancamento);
    }
    public LancamentoDTO update(Long id, LancamentoDTO body){
        Lancamento aux = lancamentoRepository.findById(id).get();
        BeanUtils.copyProperties(mapper.toDTO(body),aux,"id");
        return mapper.toLancamento(lancamentoRepository.save(aux));
    }
    public void deleteById(long id){
        lancamentoRepository.deleteById(id);
    }


}