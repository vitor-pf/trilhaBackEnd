package trilha.back.financys.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.financys.model.Lancamento;
import trilha.back.financys.repository.LancamentoRepository;
import java.util.List;

@Service
public class LancamentoService {
    @Autowired
    private LancamentoRepository lancamentoRepository;
    @Autowired
    private CategoriaService categoriaService;

    public boolean validateCategoryById(long idCategory) {
        if(categoriaService.findById(idCategory) == null){
            return false;
        }
        return true;
    }
    public void save(Lancamento lancamento){
        lancamentoRepository.save(lancamento);
    }
    public List<Lancamento> findAll(){
        List<Lancamento> lancamento = lancamentoRepository.findAll();
        return lancamento;
    }
    public Lancamento findById(long id){
        return lancamentoRepository.findById(id).get();
    }
    public void deleteById(long id){
        lancamentoRepository.deleteById(id);
    }


}