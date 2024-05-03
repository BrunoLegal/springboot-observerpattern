package com.finan.orcamento.model.builder.casa;

import com.finan.orcamento.model.Casa;

public class Casa2Quartos2BanheirosChurrasqueira implements IBuilderCasa{
    private Casa casa;
    public Casa2Quartos2BanheirosChurrasqueira(){
        casa = new Casa(2, 2, true);
    }
    @Override
    public void buildQuartos() {
        System.out.println("Quarto 1: 19x18 Quarto 2: 17x19");
    }

    @Override
    public void buildBanheiros() {
        System.out.println("Dois banheiros 10x12");
    }

    @Override
    public void buildChurrasqueira() {
        System.out.println("Com churrasqueira");
    }

    @Override
    public Casa getCasa() {
        return casa;
    }
}

