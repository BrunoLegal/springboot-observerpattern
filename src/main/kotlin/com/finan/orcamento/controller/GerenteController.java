package com.finan.orcamento.controller;

import com.finan.orcamento.model.Gerente;
import com.finan.orcamento.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/gerentes")
public class GerenteController {
    @Autowired
    GerenteService gerenteService;

    @GetMapping
    public ResponseEntity<List<Gerente>> buscaTodosGerentes(){
        return ResponseEntity.ok(gerenteService.buscarGerentes());
    }
    @GetMapping(path="/pesquisaid/{id}")
    public ResponseEntity<Gerente>buscaPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(gerenteService.buscaId(id));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Gerente>cadastraGerente(@RequestBody Gerente gerente){
        return ResponseEntity.ok(gerenteService.cadastrarGerente(gerente));
    }
    @PostMapping(path="/put/{id}")
    public ResponseEntity<Gerente>atualizaUsuario(@RequestBody Gerente gerente, @PathVariable Long id){
        Gerente gerenteNewObj=gerenteService.atualizarGerente(gerente, id);
        return ResponseEntity.ok().body(gerenteNewObj);
    }
    @DeleteMapping(path="/delete/{id}")
    public void deleteUsuario(@PathVariable Long id){
        gerenteService.deletarGerente(id);
    }
}
