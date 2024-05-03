package com.finan.orcamento.model.proxy;

import com.finan.orcamento.model.OrcamentoModel;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class OrcamentoProxy extends OrcamentoModel {
    private BigDecimal valorOrcamento;
    private Integer qtdItens;
    private BigDecimal descontoOrcamento;
    private OrcamentoModel orcamentoModel;

    @NotNull
    @Override
    public BigDecimal getValorOrcamento() {
        if(this.valorOrcamento == null){
            this.valorOrcamento = orcamentoModel.getValorOrcamento();
        }
        return valorOrcamento;
    }

    @Override
    public int getQtdItens() {
        if(this.qtdItens == null){
            this.qtdItens = orcamentoModel.getQtdItens();
        }
        return qtdItens;
    }

    public OrcamentoProxy(OrcamentoModel orcamentoModel){
        this.orcamentoModel = orcamentoModel;
    }
    @Override
    public BigDecimal getDescontoOrcamento(){
        if(this.descontoOrcamento == null){
            this.descontoOrcamento = orcamentoModel.getDescontoOrcamento();

        }
        return this.descontoOrcamento;
    }

}
