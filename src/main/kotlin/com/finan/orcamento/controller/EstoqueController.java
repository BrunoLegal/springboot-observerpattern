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
    public ResponseEntity<List<Estoque>> BuscaTodosUsuarios(){
        return ResponseEntity.ok(estoqueService.buscarEstoques());
    }
    @GetMapping(path="/pesquisaid/{id}")
    public ResponseEntity<Estoque>buscaPorId(@PathVariable Long id){
        return ResponseEntity.ok().body(estoqueService.buscaId(id));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Estoque>cadastraUsuario(@RequestBody Estoque usuarioModel){
        return ResponseEntity.ok(estoqueService.cadastrarEstoque(usuarioModel));
    }
    @PostMapping(path="/put/{id}")
    public ResponseEntity<Estoque>atualizaUsuario(@RequestBody Estoque usuarioModel, @PathVariable Long id){
        Estoque usuarioNewObj=estoqueService.atualizarEstoque(usuarioModel, id);
        return ResponseEntity.ok().body(usuarioNewObj);
    }
    @DeleteMapping(path="/delete/{id}")
    public void deleteUsuario(@PathVariable Long id){
        estoqueService.deletarEstoque(id);
    }
}
