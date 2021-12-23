package trilha.back.financys.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.dtos.LancamentoDTO;
import trilha.back.financys.mappers.LancamentoMapper;
import trilha.back.financys.model.Lancamento;
import trilha.back.financys.service.LancamentoService;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/lancamentos", produces="application/json")
@CrossOrigin(origins = "*")
public class LancamentoController {
    @Autowired
    private LancamentoService lancamentoService;
    private final LancamentoMapper mapper;

    @PostMapping()
    public ResponseEntity<LancamentoDTO> lancamentoSalva(@RequestBody Lancamento body) {
        boolean statusCategoria = lancamentoService.validateCategoryById(body.getCategory().getId());
        if(statusCategoria) {
            LancamentoDTO lancamentoDTO = lancamentoService.save(body);
            return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoDTO);
        }
        return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
    }
    @GetMapping()
    public ResponseEntity<Object> lancamentoLista() {
        return ResponseEntity.status(HttpStatus.OK).body(lancamentoService.findAll());
    }
    @GetMapping("/grafico")
    public ResponseEntity<Object> grafico() {
        return ResponseEntity.status(HttpStatus.OK).body(lancamentoService.grafico());
    }
    @GetMapping("/{id}")
    public ResponseEntity<LancamentoDTO> lancamentoUnica(@PathVariable Long id) {
        LancamentoDTO lancamentoDTO = lancamentoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(lancamentoDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LancamentoDTO> lancamentoAlterar(@PathVariable Long id, @RequestBody LancamentoDTO body){
        LancamentoDTO lancamentoDTO = lancamentoService.update(id, body);
        return ResponseEntity.status(HttpStatus.OK).body(lancamentoDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> lancamentoDeletar(@PathVariable Long id){
        lancamentoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}