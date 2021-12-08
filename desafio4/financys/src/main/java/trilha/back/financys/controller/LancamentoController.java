package trilha.back.financys.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.model.Lancamento;
import trilha.back.financys.repository.LancamentoRepository;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/lancamentos", produces="application/json")
@CrossOrigin(origins = "*")
public class LancamentoController {
    @Autowired
    private LancamentoRepository lancamentoRepository;

    @PostMapping("/criar") //lancamento
    public ResponseEntity<Lancamento> lancamentoSalva(@RequestBody Lancamento B) {
        var lancamento = new Lancamento(
                B.getName(),B.getDescription(),B.getType(),
                B.getAmount(),B.getDate(),B.getPaid(),B.getCategoryId());
        lancamentoRepository.save(lancamento);
        return ResponseEntity.ok(lancamento);
    }
    @GetMapping("/ler") //lancamento
    public ResponseEntity<List<Lancamento>> lancamentoLista() {
        List idd = lancamentoRepository.findAll();
        return ResponseEntity.ok(idd);
    }
    @GetMapping("/ler/{id}") //lancamento
    public ResponseEntity<Optional<Lancamento>> lancamentoUnica(@PathVariable Long id) {
        Optional idd = lancamentoRepository.findById(id);
        return ResponseEntity.ok(idd);
    }
    @PutMapping("/alterar/{id}")
    public ResponseEntity<Lancamento> lancamentoAlterar(@PathVariable Long id, @RequestBody Lancamento lancamentoBody){
        var aux = lancamentoRepository.findById(id).get();
        BeanUtils.copyProperties(lancamentoBody,aux,"id");
        lancamentoRepository.save(aux);
        return ResponseEntity.ok(lancamentoBody);
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> lancamentoDeletar(@PathVariable Long id){
        lancamentoRepository.deleteById(id);
        return new ResponseEntity<> (HttpStatus.OK);
    }
}
