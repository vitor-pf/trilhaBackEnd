package trilha.back.financys.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import trilha.back.financys.dtos.CategoriaDTO;
import trilha.back.financys.entity.CategoriaEntity;
import trilha.back.financys.repository.CategoriaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ModelMapper modelMapper;
    public CategoriaService(CategoriaRepository categoriaRepository, ModelMapper modelMapper) {
        this.categoriaRepository = categoriaRepository;
        this.modelMapper = modelMapper;
    }
    public long idCategoryByName(String nameCategory) {
        ArrayList<CategoriaEntity> result = categoriaRepository.findByNameCategoria(nameCategory);
        return result.isEmpty() ? -1 : result.get(0).getId();
    }




    public CategoriaDTO create(CategoriaEntity body, BindingResult result){
        if(idCategoryByName(body.getNameCategoria()) < 0 && (!result.hasErrors())){
            return maptoEntity(categoriaRepository.save(body));
        }
        return null;
    }

    public List<CategoriaDTO> readAll(){
        return maptoListEntity(categoriaRepository.findAll());
    }

    public CategoriaDTO readById(long id){
        return maptoEntity(categoriaRepository.findById(id).get());
    }

    public CategoriaDTO update(Long id, CategoriaEntity body){
        if (Objects.equals(body.getId(), categoriaRepository.findById(id).get().getId()) ) {
            return maptoEntity(categoriaRepository.save(body));
        }
        return null;
    }

    public void delete(long id){
        categoriaRepository.deleteById(id);
    }




    private CategoriaEntity mapToDto(CategoriaDTO dto) {
        return modelMapper.map(dto, CategoriaEntity.class);
    }
    private CategoriaDTO maptoEntity(CategoriaEntity entity) {
        return modelMapper.map(entity, CategoriaDTO.class);
    }
    private List<CategoriaDTO> maptoListEntity(List<CategoriaEntity> entity) {
        return (List<CategoriaDTO>) modelMapper.map(entity, new TypeToken<List<CategoriaDTO>>(){}.getType());
    }
}