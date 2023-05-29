package org.architectedfutures.helloworld;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Optional;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class App {

    public static void main(String[] args) throws Exception {
        Integer port = Integer.parseInt(
          Optional.ofNullable(System.getenv("PORT")).orElse("8080")
        );
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null);
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "Hello World from EATSv5 ";
            
            // Determine the request method
            String method = t.getRequestMethod();
            
            // Examine the request headers
            Headers hdrs = t.getRequestHeaders();
            
            // Examine the request body
            InputStream is = t.getRequestBody();
            
            // Send response headers
            t.sendResponseHeaders(200, response.length());
            // Get response output stream
            OutputStream os = t.getResponseBody();
            // Send response content
            os.write(response.getBytes());
            os.write(method.getBytes());
            // Terminate exchange
            os.close();
        }
    }

}

