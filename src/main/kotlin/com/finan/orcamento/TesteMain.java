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
        
    }
}
