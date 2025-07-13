package br.com.fabiohigor.helloworld.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProdutoDTO {

    @NotBlank
    private String nome;

    @Positive
    private double preco;

    public ProdutoDTO() {
        super();
    }

    public ProdutoDTO(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}