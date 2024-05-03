package com.finan.orcamento.controller;

import com.finan.orcamento.model.Casa;
import com.finan.orcamento.model.builder.casa.IBuilderCasa;
import com.finan.orcamento.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/casas")
public class CasaController {
    @Autowired
    private CasaService casaService;
    @GetMapping
    public ResponseEntity<List<Casa>> buscarTodasCasas(){
        return ResponseEntity.ok(casaService.buscarCasa());
    }
    @GetMapping(path = "/pesquisaid/{id}")
    public ResponseEntity<Casa> buscarCasaPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(casaService.buscaId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Casa> cadastrarCasa(@RequestBody Casa casa){
        return ResponseEntity.ok(casaService.cadastrarCasa(casa));
    }
    @PostMapping(path = "/put/{id}")
    public ResponseEntity<Casa> atualizarCasa(@RequestBody Casa casa, @PathVariable Long id){
        Casa newCasa = casaService.atualizarCasa(casa, id);
        return ResponseEntity.ok().body(newCasa);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deletarCasa(@PathVariable Long id){
        casaService.deletaCasa(id);
    }


}
