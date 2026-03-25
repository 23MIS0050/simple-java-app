// package src.main.java;
// public class App {
//  public static void main(String[] args) throws Exception {
//  System.out.println("Java CI/CD Application Started...");
//  while (true) {
//  Thread.sleep(5000);
//  System.out.println("Hello from Java CI/CD Pipeline!");
//  }
//  }
// }

import java.io.OutputStream;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", exchange -> {
            String response = "Hello from Java CI/CD Pipeline 🚀";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.setExecutor(null);
        server.start();

        System.out.println("Server started at http://localhost:8080");
    }
}