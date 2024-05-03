package com.finan.orcamento.model;

import com.finan.orcamento.interfaces.Observer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gerente")
public class Gerente implements Observer, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @Column(name = "empresa")
    private String empresa;

    public Gerente(String nome, String empresa){
        this.nome = nome;
        this.empresa = empresa;
    }

    @Override
    public void update(Estoque estoque){
        BigDecimal valor = estoque.getValor();
        BigDecimal limite = new BigDecimal(1000);
        if (valor.compareTo(limite)>0){
        System.out.println("Gerente "+nome+": Valor do produto "+estoque.getProduto()+" é maior que "+limite);
        }
    }
}
