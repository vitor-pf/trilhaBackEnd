package trilha.back.financys.controller;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.model.Categoria;
import trilha.back.financys.repository.CategoriaRepository;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/categorias", produces="application/json")
@CrossOrigin(origins = "*")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping("/")
    public ResponseEntity<Categoria> categoriaSalva(@RequestBody Categoria body) {
        var categoria = new Categoria(body.getName(),body.getDescription());
        categoriaRepository.save(categoria);
        return ResponseEntity.ok(categoria);
    }
    @GetMapping("/")
    public ResponseEntity<List<Categoria>> categoriaLista() {
        return ResponseEntity.ok(categoriaRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Categoria>> categoriaUnica(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaRepository.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> categoriaAlterar(@PathVariable Long id, @RequestBody Categoria body){
        var aux = categoriaRepository.findById(id).get();
        BeanUtils.copyProperties(body,aux,"id");
        categoriaRepository.save(aux);
        return ResponseEntity.ok(body);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> categoriaDeletar(@PathVariable Long id){
        categoriaRepository.deleteById(id);
        return new ResponseEntity<> (HttpStatus.OK);
    }
}