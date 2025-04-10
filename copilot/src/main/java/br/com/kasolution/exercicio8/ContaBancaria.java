package br.com.kasolution.exercicio8;

public class ContaBancaria {
    private String numeroConta;
    private String senha;
    private double saldo;

    public ContaBancaria(String numeroConta, String senha, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.senha = senha;
        this.saldo = saldoInicial;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean transferir(ContaBancaria contaDestino, double valor) {
        if (sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        }
        return false;
    }
}