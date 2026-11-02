package org.amarillobank.handler;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.amarillobank.dto.ClienteDTO;
import org.amarillobank.service.impl.ClienteServiceImpl;

import java.io.*;

public class ClienteHandler implements HttpHandler {
    private ClienteServiceImpl service = new ClienteServiceImpl();
    private Gson gson = new Gson();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // ESTO ES LO QUE PERMITE QUE VS CODE SE CONECTE
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");

        if ("OPTIONS".equals(exchange.getRequestMethod())) {
            exchange.sendResponseHeaders(204, -1);
            return;
        }

        if ("POST".equals(exchange.getRequestMethod())) {
            InputStreamReader reader = new InputStreamReader(exchange.getRequestBody());
            ClienteDTO dto = gson.fromJson(reader, ClienteDTO.class);
            service.registrarCliente(dto); // usa tu servicio que ya tienes

            String response = gson.toJson(dto);
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
