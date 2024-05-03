package com.finan.orcamento.interfaces;

import com.finan.orcamento.model.Estoque;

public interface Observer {
    public void update(Estoque estoque);
}
