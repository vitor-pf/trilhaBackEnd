package trilha.back.financys.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.model.Categoria;
import trilha.back.financys.repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/categorias", produces="application/json")
@CrossOrigin(origins = "*")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping("/criar") //categoria
    public ResponseEntity<Categoria> categoriaSalva(@RequestBody Categoria Body) {
        var categoria = new Categoria(Body.getName(),Body.getDescription());
        categoriaRepository.save(categoria);
        return ResponseEntity.ok(categoria);
    }
    @GetMapping("/ler") //categoria
    public ResponseEntity<List<Categoria>> categoriaLista() {
        List idd = categoriaRepository.findAll();
        return ResponseEntity.ok(idd);
    }
    @GetMapping("/ler/{id}") //categoria
    public ResponseEntity<Optional<Categoria>> categoriaUnica(@PathVariable Long id) {
        Optional idd = categoriaRepository.findById(id);
        return ResponseEntity.ok(idd);
    }
    @PutMapping("/alterar/{id}")
    public ResponseEntity<Categoria> categoriaAlterar(@PathVariable Long id, @RequestBody Categoria categoriaBody){
        var aux = categoriaRepository.findById(id).get();
        BeanUtils.copyProperties(categoriaBody,aux,"id");
        categoriaRepository.save(aux);
        return ResponseEntity.ok(categoriaBody);
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> categoriaDeletar(@PathVariable Long id){
        categoriaRepository.deleteById(id);
        return new ResponseEntity<> (HttpStatus.OK);
    }
}
