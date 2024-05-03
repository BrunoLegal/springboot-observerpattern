package com.finan.orcamento;

import com.finan.orcamento.model.Casa;
import com.finan.orcamento.model.builder.casa.*;
import com.finan.orcamento.service.CasaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TesteMain {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(TesteMain.class, args);
        CasaService orcamentoService = context.getBean(CasaService.class);

        IBuilderCasa builderCasa1 = new Casa2Quartos();
        builderCasa1.buildQuartos();
        builderCasa1.buildBanheiros();
        builderCasa1.buildChurrasqueira();
        Casa casa1 = builderCasa1.getCasa();
        orcamentoService.cadastrarCasa(casa1);

        System.out.println("Casa 1: ");
        System.out.println("Quartos " + casa1.getQuartos());
        System.out.println("Banheiros " + casa1.getBanheiros());
        System.out.println("Churrasqueira: " + casa1.isChurrasqueira());

        System.out.println("------------------------------------------");

        IBuilderCasa builderCasa2 = new Casa2Quartos2BanheirosChurrasqueira();
        builderCasa2.buildQuartos();
        builderCasa2.buildBanheiros();
        builderCasa2.buildChurrasqueira();
        Casa casa2 = builderCasa2.getCasa();
        orcamentoService.cadastrarCasa(casa2);

        System.out.println("Casa 2: ");
        System.out.println("Quartos " + casa2.getQuartos());
        System.out.println("Banheiros " + casa2.getBanheiros());
        System.out.println("Churrasqueira: " + casa2.isChurrasqueira());

        System.out.println("------------------------------------------");

        IBuilderCasa builderCasa3 = new Casa1Quarto();
        builderCasa3.buildQuartos();
        builderCasa3.buildBanheiros();
        builderCasa3.buildChurrasqueira();
        Casa casa3 = builderCasa3.getCasa();
        orcamentoService.cadastrarCasa(casa3);

        System.out.println("Casa 3: ");
        System.out.println("Quartos " + casa3.getQuartos());
        System.out.println("Banheiros " + casa3.getBanheiros());
        System.out.println("Churrasqueira: " + casa3.isChurrasqueira());

        System.out.println("------------------------------------------");

        IBuilderCasa builderCasa4 = new Casa5Quartos2BanheirosChurrasqueira();
        builderCasa4.buildQuartos();
        builderCasa4.buildBanheiros();
        builderCasa4.buildChurrasqueira();
        Casa casa4 = builderCasa4.getCasa();
        orcamentoService.cadastrarCasa(casa4);

        System.out.println("Casa 4: ");
        System.out.println("Quartos " + casa4.getQuartos());
        System.out.println("Banheiros " + casa4.getBanheiros());
        System.out.println("Churrasqueira: " + casa4.isChurrasqueira());

        System.out.println("------------------------------------------");

        IBuilderCasa builderCasa5 = new CasaComNada();
        builderCasa5.buildQuartos();
        builderCasa5.buildBanheiros();
        builderCasa5.buildChurrasqueira();
        Casa casa5 = builderCasa5.getCasa();
        orcamentoService.cadastrarCasa(casa5);

        System.out.println("Casa 5: ");
        System.out.println("Quartos " + casa5.getQuartos());
        System.out.println("Banheiros " + casa5.getBanheiros());
        System.out.println("Churrasqueira: " + casa5.isChurrasqueira());
    }
}
