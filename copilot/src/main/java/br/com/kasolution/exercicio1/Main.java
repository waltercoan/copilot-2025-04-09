package br.com.kasolution.exercicio1;

public class Main {
    // Declara um método estático chamado "calcularMedia" que recebe um array de números do tipo double como parâmetro e retorna um valor do tipo double.
    public static double calcularMedia(double[] numeros) { 
        double soma = 0; 
        // Inicializa uma variável chamada "soma" com o valor 0. Esta variável será usada para armazenar a soma de todos os números no array.

        for (double numero : numeros) { 
            // Inicia um loop "for-each" que percorre cada elemento do array "numeros". 
            // A cada iteração, o valor do elemento atual é atribuído à variável "numero".

            soma += numero; 
            // Adiciona o valor do elemento atual (armazenado em "numero") à variável "soma".
        }

        return soma / numeros.length; 
        // Retorna o resultado da divisão da soma total pelo número de elementos no array "numeros".
        // Isso calcula a média dos números no array.
    }

    //defina um método main que chame a funcao calcularMedia
    public static void main(String[] args) {
        double[] numeros = {1, 2, 3, 4, 5};
        double media = calcularMedia(numeros);
        System.out.println("A média é: " + media);
    }
    //defina um método para calcular a media de uma lista de numeros utilizando o método Stream
    public static double calcularMediaStream(double[] numeros) {
        return java.util.Arrays.stream(numeros).average().orElse(0);
    }	
}
