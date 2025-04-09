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
        try {
            URL url = new URL(urlApi);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            int codigoResposta = conexao.getResponseCode();
            if (codigoResposta == HttpURLConnection.HTTP_OK) {
                try (BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream()))) {
                    String linha;
                    StringBuilder resposta = new StringBuilder();
                    while ((linha = leitor.readLine()) != null) {
                        resposta.append(linha).append("\n");
                    }
                    System.out.println("Resposta da API:\n" + resposta);
                }
            } else {
                System.err.println("Erro na chamada da API. Código de resposta: " + codigoResposta);
            }
        } catch (Exception e) {
            System.err.println("Erro ao chamar a API: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        gerarCSV("dados.csv");
        
        chamarApiRest("https://api.exemplo.com/dados");
        
    }
}
