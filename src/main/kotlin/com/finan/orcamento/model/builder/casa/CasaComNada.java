package com.finan.orcamento.model.builder.casa;

import com.finan.orcamento.model.Casa;

public class CasaComNada implements IBuilderCasa{

    private Casa casa;

    public CasaComNada(){
        casa = new Casa(0, 0, false);
    }
    @Override
    public void buildQuartos() {
        System.out.println("Sem quarto");
    }

    @Override
    public void buildBanheiros() {
        System.out.println("Sem Banheiro");
    }

    @Override
    public void buildChurrasqueira() {
        System.out.println("Sem churrasqueira");
    }

    @Override
    public Casa getCasa() {
        return casa;
    }
}
