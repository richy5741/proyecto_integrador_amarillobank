package org.amarillobank;
import com.sun.net.httpserver.HttpServer;
import org.amarillobank.config.DatabaseConfig;
import org.amarillobank.handler.ClienteHandler;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        DatabaseConfig.initDatabase();
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/api/clientes", new ClienteHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Backend AmarilloBank corriendo en http://localhost:8080");
    }
}