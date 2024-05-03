package com.finan.orcamento.model.builder.casa;

import com.finan.orcamento.model.Casa;

public class Casa2Quartos implements IBuilderCasa{

    private Casa casa;

    public Casa2Quartos(){
        casa = new Casa(2, 1, false);
    }
    @Override
    public void buildQuartos() {
        System.out.println("Quarto 1: 19x18 Quarto 2: 17x19");
    }

    @Override
    public void buildBanheiros() {
        System.out.println("Um banheiro 10x12");
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
