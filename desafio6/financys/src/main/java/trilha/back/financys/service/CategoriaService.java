package trilha.back.financys.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.financys.dtos.CategoriaDTO;
import trilha.back.financys.mappers.CategoriaMapper;
import trilha.back.financys.model.Categoria;
import trilha.back.financys.repository.CategoriaRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;
    private final CategoriaMapper mapper;

    public long idCategoryByName(String nameCategory) {
        ArrayList<Categoria> result = categoriaRepository.findByName(nameCategory);
        return result.isEmpty() ? -1 : result.get(0).getId();
    }
    public CategoriaDTO save(Categoria categoria){
        Categoria result = categoriaRepository.save(categoria);
        return mapper.toCategoriaDTO(result);
    }
    public List<CategoriaDTO> findAll(){
        List<Categoria> categoria = categoriaRepository.findAll();
        return mapper.toListCategoriaDTO(categoria);
    }
    public CategoriaDTO findById(long id){
        Categoria categoria = categoriaRepository.findById(id).get();
        return mapper.toCategoriaDTO(categoria);
    }
    public CategoriaDTO update(Long id, Categoria body){
        Categoria aux = categoriaRepository.findById(id).get();
        BeanUtils.copyProperties(body,aux,"id");
        return mapper.toCategoriaDTO(categoriaRepository.save(aux));
    }
    public void deleteById(long id){
        categoriaRepository.deleteById(id);
    }


}