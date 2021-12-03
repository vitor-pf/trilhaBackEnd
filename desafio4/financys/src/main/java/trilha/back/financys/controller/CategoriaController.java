package trilha.back.financys.controller;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.model.Categoria;
import trilha.back.financys.repository.CategoriaRepository;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/categorias", produces="application/json")
@CrossOrigin(origins = "*")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;
    private ArrayList<Categoria> lista = new ArrayList<Categoria>();

    @PostMapping("/criar") //categoria
    public ResponseEntity<Categoria> categoriaSalva(@RequestBody Categoria Body) {
        var categoria = new Categoria(Body.getId(),Body.getName(),Body.getDescription());
        categoriaRepository.save(categoria);
        lista.add(categoria);
        return ResponseEntity.ok(categoria);
    }
    @GetMapping("/ler") //categoria
    public ResponseEntity<ArrayList<Categoria>> categoriaLista() {
        categoriaRepository.findAll();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/ler/{id}") //categoria
    public ResponseEntity<ArrayList<Categoria>> categoriaUnica(@PathVariable Long id) {
        var idd = categoriaRepository.findById(id).get();
        System.out.println(idd);
        return ResponseEntity.ok(lista);
    }
    @PutMapping("/alterar/{id}")
    public ResponseEntity<Categoria> categoriaAlterar(@PathVariable Long id, @RequestBody Categoria categoriaBody){
        var aux = categoriaRepository.findById(id).get();
        BeanUtils.copyProperties(categoriaBody,aux,"id");
        lista.add(categoriaBody);
        categoriaRepository.save(aux);
        return ResponseEntity.ok(categoriaBody);
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> categoriaDeletar(@PathVariable Long id){
        categoriaRepository.deleteById(id);
        return new ResponseEntity<> (HttpStatus.OK);
    }
}
