package trilha.back.financys.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.model.Lancamento;
import trilha.back.financys.service.LancamentoService;

import java.util.List;

@RestController
@RequestMapping(value = "/lancamentos", produces="application/json")
@CrossOrigin(origins = "*")
public class LancamentoController {
    @Autowired
    private LancamentoService lancamentoService;

    @PostMapping()
    public ResponseEntity<Lancamento> lancamentoSalva(@RequestBody Lancamento body) {
        boolean statusCategoria = lancamentoService.validateCategoryById(body.getCategory().getId());
        if(statusCategoria == true) {
            lancamentoService.save(body);
            return ResponseEntity.status(HttpStatus.CREATED).body(body);
        }
        return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
    }
    @GetMapping()
    public ResponseEntity<List<Lancamento>> lancamentoLista() {
        List<Lancamento> lancamento = lancamentoService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(lancamento);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> lancamentoUnica(@PathVariable Long id) {
        Lancamento lancamento = lancamentoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(lancamento);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Lancamento> lancamentoAlterar(@PathVariable Long id, @RequestBody Lancamento body){
        Lancamento aux = lancamentoService.findById(id);
        BeanUtils.copyProperties(body,aux,"id");
        lancamentoService.save(aux);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> lancamentoDeletar(@PathVariable Long id){
        lancamentoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}