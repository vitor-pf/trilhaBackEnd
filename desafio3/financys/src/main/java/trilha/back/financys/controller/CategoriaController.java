package trilha.back.financys.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.Categoria;
import java.util.ArrayList;
import java.util.List;


@RestController
@ResponseBody
@RequestMapping(value = "/categoria")
@Api(value = "FinancysApplication")
@CrossOrigin(origins = "*") //Liberar qualquer dominio para acessar *libera todos
public class CategoriaController {
    private ArrayList<Categoria> lista = new ArrayList<Categoria>();


    @GetMapping("/ler") //categoria
    @ApiOperation(value = "Retorna todas categorias")
    public ResponseEntity<List<Categoria>> categoriaLista() {
        return ResponseEntity.ok(lista);
    }
    @PostMapping("/criar") //categoria
    @ApiOperation(value = "Cria uma categoria")
    public ResponseEntity<Categoria> categoriaSalva(@RequestBody Categoria categoriaBody) {
        var categoria = new Categoria();
        categoria.setId(categoriaBody.getId());
        categoria.setName(categoriaBody.getName());
        categoria.setDescription(categoriaBody.getDescription());
        lista.add(categoria);
        return ResponseEntity.ok(categoria);
    }
}
