package com.finan.orcamento.model.builder.casa;

import com.finan.orcamento.model.Casa;

public class Casa5Quartos2BanheirosChurrasqueira implements IBuilderCasa{

    private Casa casa;

    public Casa5Quartos2BanheirosChurrasqueira(){
        casa = new Casa(5, 2, true);
    }
    @Override
    public void buildQuartos() {
        System.out.println("3 quartos: 3,5 x 3; 2 quartos 1: 2,5 x 3");
    }

    @Override
    public void buildBanheiros() {
        System.out.println("Dois banheiros 2 x 2");
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
