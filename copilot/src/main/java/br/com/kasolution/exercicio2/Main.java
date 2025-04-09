package br.com.kasolution.exercicio2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void gerarCSV(String nomeArquivo) {
        String conteudo = "Nome,Idade,Endereco\n"
                        + "João,25,Rua A, 123\n"
                        + "Maria,30,Rua B, 456\n"
                        + "Carlos,35,Rua C, 789\n";

        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            writer.write(conteudo);
            System.out.println("Arquivo CSV gerado com sucesso: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao gerar o arquivo CSV: " + e.getMessage());
        }
    }

    public static void chamarApiRest(String urlApi) {
        // Inicia um bloco try para capturar exceções que possam ocorrer durante a execução.
        try {
            // Cria um objeto URL a partir da string fornecida como parâmetro.
            URL url = new URL(urlApi);

            // Abre uma conexão HTTP com a URL especificada.
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            // Define o método HTTP como GET para a requisição.
            conexao.setRequestMethod("GET");

            // Obtém o código de resposta HTTP da requisição.
            int codigoResposta = conexao.getResponseCode();

            // Verifica se o código de resposta indica sucesso (HTTP 200).
            if (codigoResposta == HttpURLConnection.HTTP_OK) {
                // Usa try-with-resources para garantir que o BufferedReader será fechado automaticamente.
                try (BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream()))) {
                    String linha;
                    StringBuilder resposta = new StringBuilder();

                    // Lê a resposta da API linha por linha.
                    while ((linha = leitor.readLine()) != null) {
                        // Adiciona cada linha ao StringBuilder, separando-as com uma nova linha.
                        resposta.append(linha).append("\n");
                    }

                    // Imprime a resposta completa da API no console.
                    System.out.println("Resposta da API:\n" + resposta);
                }
            } else {
                // Caso o código de resposta não seja 200, exibe uma mensagem de erro com o código.
                System.err.println("Erro na chamada da API. Código de resposta: " + codigoResposta);
            }
        } catch (Exception e) {
            // Captura qualquer exceção que ocorra e exibe uma mensagem de erro no console.
            System.err.println("Erro ao chamar a API: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        gerarCSV("dados.csv");
        
        chamarApiRest("https://api.exemplo.com/dados");
        
    }
}
