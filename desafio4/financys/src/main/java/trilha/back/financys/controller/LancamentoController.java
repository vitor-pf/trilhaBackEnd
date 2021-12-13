package trilha.back.financys.controller;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.model.Lancamento;
import trilha.back.financys.repository.LancamentoRepository;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/lancamentos", produces="application/json")
@CrossOrigin(origins = "*")
public class LancamentoController {
    @Autowired
    private LancamentoRepository lancamentoRepository;

    @PostMapping("/")
    public ResponseEntity<Lancamento> lancamentoSalva(@RequestBody Lancamento body) {
        var lancamento = new Lancamento(
                body.getName(),body.getDescription(),body.getType(),
                body.getAmount(),body.getDate(),body.getPaid(),body.getCategoryId());
        lancamentoRepository.save(lancamento);
        System.out.println(body.getCategoryId());
        return ResponseEntity.ok(lancamento);
    }
    @GetMapping("/")
    public ResponseEntity<List<Lancamento>> lancamentoLista() {
        return ResponseEntity.ok(lancamentoRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Lancamento>> lancamentoUnica(@PathVariable Long id) {
        return ResponseEntity.ok(lancamentoRepository.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Lancamento> lancamentoAlterar(@PathVariable Long id, @RequestBody Lancamento body){
        var aux = lancamentoRepository.findById(id).get();
        BeanUtils.copyProperties(body,aux,"id");
        lancamentoRepository.save(aux);
        return ResponseEntity.ok(body);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> lancamentoDeletar(@PathVariable Long id){
        lancamentoRepository.deleteById(id);
        return new ResponseEntity<> (HttpStatus.OK);
    }
}