package br.com.zup.edu.marketplace.controller;

import br.com.zup.edu.marketplace.model.Produto;

import java.math.BigDecimal;

public class ProdutosResponse {

    private final String titulo;
    private final String descricao;
    private final BigDecimal preco;

    public ProdutosResponse(Produto produto) {
        this.titulo = produto.getTitulo();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();

    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
