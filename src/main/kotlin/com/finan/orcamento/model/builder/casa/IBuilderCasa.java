package com.finan.orcamento.model.builder.casa;

import com.finan.orcamento.model.Casa;

public interface IBuilderCasa {
    void buildQuartos();
    void buildBanheiros();
    void buildChurrasqueira();
    Casa getCasa();
}
