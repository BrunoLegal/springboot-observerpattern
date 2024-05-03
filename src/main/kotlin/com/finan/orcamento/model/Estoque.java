package com.finan.orcamento.model;

import com.finan.orcamento.interfaces.Observer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.jdbc.mutation.spi.BindingGroup;
import org.hibernate.mapping.Join;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="estoque")
public class Estoque implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "produto")
    private String produto;

    @NotNull
    @Column(name = "valor")
    private BigDecimal valor; //observar esse atributo

    @Column(name = "desconto")
    private BigDecimal desconto;

    @Transient //não entendo como eu deveria inserir esse dado em uma database
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public Estoque(String produto, BigDecimal valor, BigDecimal desconto){
        this.produto = produto;
        this.valor = valor;
        this.desconto = desconto;
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update(this);
        }
    }

    public void setValor(BigDecimal valor){
        this.valor = valor;
        notifyObservers();
    }


}
