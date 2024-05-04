package com.finan.orcamento.service;

import com.finan.orcamento.model.Gerente;
import com.finan.orcamento.repositories.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class GerenteService {
    @Autowired
    GerenteRepository gerenteRepository;

    public List<Gerente> buscarGerentes(){
        return gerenteRepository.findAll();
    }

    public Gerente buscaId(Long id){
        Optional<Gerente> obj = gerenteRepository.findById(id);
        if(obj.isPresent()){
            return obj.get();
        }else {
            throw new RuntimeException("Gerente não encontrado!");
        }
    }

    public Gerente cadastrarGerente(Gerente gerente){
        return gerenteRepository.save(gerente);
    }

    public Gerente atualizarGerente(Gerente gerente, Long id){
        Gerente newGerente = buscaId(id);
        newGerente.setNome(gerente.getNome());
        newGerente.setEmpresa(gerente.getEmpresa());
        return gerenteRepository.save(newGerente);
    }
}
