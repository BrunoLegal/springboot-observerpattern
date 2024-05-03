package com.finan.orcamento.model.builder.casa;

import com.finan.orcamento.model.Casa;

public class Casa1Quarto implements IBuilderCasa {

    private Casa casa;

    public Casa1Quarto(){
        casa = new Casa(1, 1, false);
    }
    @Override
    public void buildQuartos() {
        System.out.println("Quarto 1: 19x18 ");}
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
