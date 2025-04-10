package br.com.kasolution.exercicio6;

/**
 * Classe que representa um caixa de supermercado.
 * 
 * A classe gerencia o fluxo de atendimento de clientes, permitindo que eles
 * adicionem itens a um carrinho, calculem o total da compra e decidam se o caixa
 * deve ser fechado.
 */
import java.util.Scanner;

/**
 * Classe principal que simula o funcionamento de um caixa.
 */
public class Caixa {

    /**
     * Indica se o caixa está aberto ou fechado.
     */
    private boolean aberto;

    /**
     * Construtor da classe Caixa.
     * 
     * Inicializa o caixa como aberto.
     */
    public Caixa() {
        this.aberto = true; // O caixa começa aberto.
    }

    /**
     * Método principal que inicia o funcionamento do caixa.
     * 
     * Este método gerencia o fluxo de atendimento de clientes, permitindo que eles
     * adicionem itens ao carrinho, visualizem os itens comprados e o total da
     * compra, e decidam se o caixa deve ser fechado.
     */
    public void iniciar() {
        Scanner scanner = new Scanner(System.in); // Scanner para entrada de dados do usuário.

        // Loop principal que mantém o caixa aberto enquanto a variável 'aberto' for true.
        while (aberto) {
            Carrinho carrinho = new Carrinho(); // Cria um novo carrinho para o cliente atual.
            System.out.println("Novo cliente no caixa."); // Mensagem indicando o início do atendimento.

            boolean maisItens = true; // Controle para adicionar itens ao carrinho.
            while (maisItens) {
                System.out.print("Digite o nome do item: ");
                String nome = scanner.nextLine(); // Lê o nome do item.

                System.out.print("Digite o preço do item: ");
                double preco = scanner.nextDouble(); // Lê o preço do item.
                scanner.nextLine(); // Consome a quebra de linha pendente.

                // Adiciona o item ao carrinho.
                carrinho.adicionarItem(new Item(nome, preco));

                System.out.print("Há mais itens? (s/n): ");
                String resposta = scanner.nextLine(); // Lê a resposta do usuário.
                maisItens = resposta.equalsIgnoreCase("s"); // Continua adicionando itens se a resposta for "s".
            }

            // Exibe os itens comprados e o total da compra.
            System.out.println("Itens comprados:");
            carrinho.exibirItens();
            System.out.printf("Total da compra: R$ %.2f%n", carrinho.calcularTotal());

            // Pergunta ao usuário se deseja fechar o caixa.
            System.out.print("Deseja fechar o caixa? (s/n): ");
            String fecharCaixa = scanner.nextLine();
            if (fecharCaixa.equalsIgnoreCase("s")) {
                aberto = false; // Fecha o caixa se a resposta for "s".
            }
        }

        System.out.println("Caixa fechado."); // Mensagem indicando que o caixa foi fechado.
        scanner.close(); // Fecha o scanner para liberar recursos.
    }
}