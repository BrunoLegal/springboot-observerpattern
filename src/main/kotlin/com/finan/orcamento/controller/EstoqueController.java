package com.finan.orcamento.controller;

import com.finan.orcamento.model.Estoque;
import com.finan.orcamento.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/estoque")
public class EstoqueController {
    @Autowired
    EstoqueService estoqueService;

    @GetMapping
    public ResponseEntity<List<Estoque>> buscaTodosEstoques(){
        return ResponseEntity.ok(estoqueService.buscarEstoques());
    }
    @GetMapping(path="/pesquisaid/{id}")
    public ResponseEntity<Estoque>buscaPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(estoqueService.buscaId(id));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Estoque>cadastraEstoque(@RequestBody Estoque estoque){
        return ResponseEntity.ok(estoqueService.cadastrarEstoque(estoque));
    }
    @PostMapping(path="/put/{id}")
    public ResponseEntity<Estoque>atualizaEstoque(@RequestBody Estoque estoque, @PathVariable Long id){
        Estoque estoqueNewObj=estoqueService.atualizarEstoque(estoque, id);
        return ResponseEntity.ok().body(estoqueNewObj);
    }
    @DeleteMapping(path="/delete/{id}")
    public void deleteEstoque(@PathVariable Long id){
        estoqueService.deletarEstoque(id);
    }
}
