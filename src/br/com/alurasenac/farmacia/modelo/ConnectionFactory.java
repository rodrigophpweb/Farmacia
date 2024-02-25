package br.com.alurasenac.farmacia.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection recuperarConexao(){

        String dbUrl = "jdbc:mysql://localhost:3306/farmacia";
        String dbUser = System.getenv("DB_USER");
        String dbPassword = System.getenv("DB_PASSWORD");

        try {
            return DriverManager.getConnection(dbUrl, dbUser, dbPassword);

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}