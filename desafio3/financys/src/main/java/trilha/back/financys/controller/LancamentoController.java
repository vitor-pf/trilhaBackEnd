package trilha.back.financys.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.Lancamento;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/lancamento")
public class LancamentoController {
    private ArrayList<Lancamento>lista = new ArrayList<Lancamento>();

    @GetMapping(path ="/ler")
    public ResponseEntity<List<Lancamento>> LancamentoLista(){
        return ResponseEntity.ok(lista);
    }


    @PostMapping("/criar")
    public ResponseEntity<Lancamento> LancamentoSalva(@RequestBody Lancamento lancamentoBody){

        var lancamento = new Lancamento();
        lancamento.setId(lancamentoBody.getId());
        lancamento.setName(lancamentoBody.getName());
        lancamento.setDescription(lancamentoBody.getDescription());
        lancamento.setType(lancamentoBody.getType());
        lancamento.setAmount(lancamentoBody.getAmount());
        lancamento.setDate(lancamentoBody.getDate());

        lista.add(lancamento);
        return ResponseEntity.ok(lancamento);
    }
}
