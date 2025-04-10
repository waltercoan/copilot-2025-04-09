package br.com.kasolution.exercicio5;

public class MainClass {
    public static void main(String[] args) {
        // Criação de um objeto da classe Carro
        Carro carro = new Carro("Toyota", "Corolla", "Preto", 2022);

        // Acessando os métodos da classe Carro
        carro.imprimir();
        System.out.println("O carro está disponível para venda? " + carro.vender());
    }
}
