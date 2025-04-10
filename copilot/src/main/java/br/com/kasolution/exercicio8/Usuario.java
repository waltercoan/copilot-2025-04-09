package br.com.kasolution.exercicio8;

public class Usuario {
    private String nome;
    private ContaBancaria conta;

    public Usuario(String nome, ContaBancaria conta) {
        this.nome = nome;
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public ContaBancaria getConta() {
        return conta;
    }
}