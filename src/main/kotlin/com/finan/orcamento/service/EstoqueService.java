package com.finan.orcamento.service;

import com.finan.orcamento.model.Estoque;
import com.finan.orcamento.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository estoqueRepository;
    public List<Estoque> buscarEstoques(){
        return estoqueRepository.findAll();
    }
    public Estoque buscaId(Long id){
        Optional<Estoque> obj = estoqueRepository.findById(id);
        if(obj.isPresent()){
            return obj.get();
        }else{
            throw new RuntimeException("Usuario não encontrado!");
        }
    }

    public Estoque cadastrarEstoque(Estoque estoque){
        return estoqueRepository.save(estoque);
    }
    public Estoque atualizarEstoque(Estoque estoque){
        Estoque newEstoque = buscaId(estoque.getId());
        newEstoque.setProduto(estoque.getProduto());
        newEstoque.setDesconto(estoque.getDesconto());
        newEstoque.setValor(estoque.getValor());
        return estoqueRepository.save(newEstoque);
    }

    public void deletarEstoque(Long id){
        estoqueRepository.deleteById(id);
    }
}
