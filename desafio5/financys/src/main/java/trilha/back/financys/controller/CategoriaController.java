package trilha.back.financys.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.model.Categoria;
import trilha.back.financys.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias", produces="application/json")
@CrossOrigin(origins = "*")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping()
    public ResponseEntity<Categoria> categoriaSalva(@RequestBody Categoria body) {
        if(categoriaService.idCategoryByName(body.getName()) == 0){
            categoriaService.save(body);
            return ResponseEntity.status(HttpStatus.CREATED).body(body);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping()
    public ResponseEntity<List<Categoria>> categoriaLista() {
        List categoria = categoriaService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> categoriaUnica(@PathVariable Long id) {
        Categoria categoria = categoriaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> categoriaAlterar(@PathVariable Long id, @RequestBody Categoria body){
        Categoria aux = categoriaService.findById(id);
        BeanUtils.copyProperties(body,aux,"id");
        categoriaService.save(aux);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> categoriaDeletar(@PathVariable Long id){
        categoriaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}