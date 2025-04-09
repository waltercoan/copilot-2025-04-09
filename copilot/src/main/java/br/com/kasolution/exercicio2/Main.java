package br.com.kasolution.exercicio2;

import java.io.FileWriter;
import java.io.IOException;

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

    public static void main(String[] args) {
        gerarCSV("dados.csv");
    }
}
