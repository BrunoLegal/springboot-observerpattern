package com.finan.orcamento.service;

import com.finan.orcamento.model.Casa;
import com.finan.orcamento.model.builder.casa.IBuilderCasa;
import com.finan.orcamento.repositories.CasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CasaService {
    @Autowired
    private CasaRepository casaRepository;

    public List<Casa> buscarCasa(){
        return casaRepository.findAll();
    }

    public Casa buscaId(Long id){
        Optional<Casa>obj=casaRepository.findById(id);
        if(obj.isPresent()){
            return obj.get();
        }else{
            throw new RuntimeException("Casa não encontrada");
        }
    }

    public Casa cadastrarCasa(Casa casa){
        return casaRepository.save(casa);
    }
    public Casa atualizarCasa(Casa casa, Long id){
        Casa tempCasa = buscaId(id);
        Casa newCasa = new Casa(tempCasa.getId(), casa.getQuartos(), casa.getBanheiros(), casa.isChurrasqueira());
        return casaRepository.save(newCasa);
    }

    public void deletaCasa(Long id){
        casaRepository.deleteById(id);
    }
}
