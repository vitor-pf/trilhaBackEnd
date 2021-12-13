package trilha.back.financys.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.financys.model.Categoria;
import trilha.back.financys.repository.CategoriaRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public long idCategoryByName(String nameCategory) {
        ArrayList<Categoria> result = categoriaRepository.findByName(nameCategory);
        return result.isEmpty() ? 0 : result.get(0).getId();
    }
    public void save(Categoria categoria){
        categoriaRepository.save(categoria);
    }
    public List<Categoria> findAll(){
        List<Categoria> categoria =categoriaRepository.findAll();
        return categoria;
    }
    public Categoria findById(long id){
        return categoriaRepository.findById(id).get();
    }
    public void deleteById(long id){
        categoriaRepository.deleteById(id);
    }


}