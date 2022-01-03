package trilha.back.financys.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.dtos.LancamentoDTO;
import trilha.back.financys.entity.LancamentoEntity;
import trilha.back.financys.mappers.LancamentoMapper;
import trilha.back.financys.service.LancamentoService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/lancamentos", produces="application/json")
@CrossOrigin(origins = "*")
public class LancamentoController {
    @Autowired
    private LancamentoService lancamentoService;
    private final LancamentoMapper mapper;

    @GetMapping("/graficoTeste")
    public ResponseEntity<?> graficoTeste() {
        return ResponseEntity.status(HttpStatus.OK).body(lancamentoService.grafico());
    }
    @PostMapping("/")
    public ResponseEntity<LancamentoDTO> create(@RequestBody @Valid LancamentoEntity body,
                                                         BindingResult result) {
        return lancamentoService.create(body, result);
    }
    @GetMapping("/")
    public ResponseEntity<List<LancamentoDTO>> readAll() {
        return lancamentoService.readAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<LancamentoDTO> lancamentoUnica(@PathVariable Long id) {
        return lancamentoService.readById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LancamentoDTO> lancamentoAlterar(@PathVariable Long id, @RequestBody @Valid LancamentoEntity body){
        return lancamentoService.update(id, body);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> lancamentoDeletar(@PathVariable Long id){
        lancamentoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}