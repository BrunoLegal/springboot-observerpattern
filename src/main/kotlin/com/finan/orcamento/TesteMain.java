package com.finan.orcamento;

import com.finan.orcamento.model.Estoque;
import com.finan.orcamento.model.Gerente;
import com.finan.orcamento.service.EstoqueService;
import com.finan.orcamento.service.GerenteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class TesteMain {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TesteMain.class, args);
        GerenteService gerenteService = context.getBean(GerenteService.class);
        EstoqueService estoqueService = context.getBean(EstoqueService.class);

        BigDecimal valor = new BigDecimal("100");
        BigDecimal desconto = new BigDecimal("20");

        Gerente gerente = new Gerente("Augusto","Amazon");
        Estoque estoque = new Estoque("Livros", valor, desconto);

        /* DESCOMENTE PARA ADICIONAR AO BANCO, O CRUD FUNCIONA
        gerenteService.cadastrarGerente(gerente);
        estoqueService.cadastrarEstoque(estoque);
        */
        estoque.attach(gerente);

        System.out.println("---------------------VALOR DE 100-------------------------------");
        estoque.setValor(valor);
        System.out.println("----------------------------------------------------------------");


        Gerente outroGerente = new Gerente("Pedro", "Google");
        estoque.attach(outroGerente);
        valor = new BigDecimal(2000);

        System.out.println("---------------------VALOR de 2000------------------------------");
        estoque.setValor(valor);
        System.out.println("----------------------------------------------------------------");

    }
}
