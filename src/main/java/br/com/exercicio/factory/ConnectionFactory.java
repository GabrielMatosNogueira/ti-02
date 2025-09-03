// CÓDIGO CORRETO E ATUALIZADO
package br.com.exercicio.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/exercicio02_db";
    private static final String USER = "nogueira";    // <-- ALTERADO
    private static final String PASSWORD = "2812";        // <-- ALTERADO

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            // Se der erro aqui, pode ser um problema de permissão no banco
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }
}