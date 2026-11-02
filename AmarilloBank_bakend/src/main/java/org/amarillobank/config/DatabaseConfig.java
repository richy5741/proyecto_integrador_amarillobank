package org.amarillobank.config;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/amarillobank?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void initDatabase() {
        try (Connection conn = getConnection()) {
            System.out.println(">> Conectado a XAMPP MySQL - usando tabla existente de 5 columnas");
        } catch (Exception e) {
            throw new RuntimeException("Prende MySQL en XAMPP: " + e.getMessage(), e);
        }
    }
}