package trilha.back.financys.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.dtos.CategoriaDTO;
import trilha.back.financys.model.Categoria;
import trilha.back.financys.service.CategoriaService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/categorias", produces="application/json")
@CrossOrigin(origins = "*")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping()
    public ResponseEntity<CategoriaDTO> categoriaSalva(@RequestBody Categoria body) {
        if(categoriaService.idCategoryByName(body.getName()) < 0){
            CategoriaDTO categoriaDTO= categoriaService.save(body);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaDTO);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping()
    public ResponseEntity<List<CategoriaDTO>> categoriaLista() {
        List categoria = categoriaService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> categoriaUnica(@PathVariable Long id) {
        CategoriaDTO categoriaDTO = categoriaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoriaDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> categoriaAlterar(@PathVariable Long id, @RequestBody Categoria body){
        CategoriaDTO categoriaDTO = categoriaService.update(id, body);
        return ResponseEntity.status(HttpStatus.OK).body(categoriaDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> categoriaDeletar(@PathVariable Long id){
        categoriaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}