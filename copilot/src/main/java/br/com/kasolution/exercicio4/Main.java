package br.com.kasolution.exercicio4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    /**
     * Método para gerenciar a conexão com um banco de dados SQL Server.
     * @param urlConexao A URL de conexão com o banco de dados.
     * @return Um objeto Connection se a conexão for bem-sucedida.
     * @throws SQLException Se ocorrer um erro ao tentar conectar.
     */
    public static Connection conectarBanco(String urlConexao) throws SQLException {
        // Tenta estabelecer uma conexão com o banco de dados usando a URL fornecida.
        return DriverManager.getConnection(urlConexao);
    }

    public static void main(String[] args) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=exemplo";
        try {
            // Chama o método conectarBanco e obtém a conexão.
            Connection conexao = conectarBanco(url);
            System.out.println("Conexão estabelecida com sucesso!");
            // Fecha a conexão após o uso.
            conexao.close();
        } catch (SQLException e) {
            // Exibe uma mensagem de erro caso a conexão falhe.
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}
