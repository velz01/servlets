package com.velz.other.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    private final ExecutorService pool;
    private final int port;
    private boolean stopped;

    public HttpServer(int poolSize, int port) {
        this.pool = Executors.newFixedThreadPool(poolSize);
        this.port = port;
    }
    public void run() {
        try (ServerSocket server = new ServerSocket(port)) {
            while (!stopped) {
                Socket socket = server.accept();
                pool.submit(() -> processSocket(socket));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void processSocket(Socket socket) {
        try (DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream())) {
            // request
            System.out.println("Request: " + new String(inputStream.readNBytes(400)));
            // response
            
            byte[] body = Files.readAllBytes(Path.of("src/resources", "site.html"));
            byte[] headers = """
                    HTTP/1.1 200 OK
                    content-type: text/html
                    content-length: %s
                    """.formatted(body.length).getBytes();
            outputStream.write(headers);
            outputStream.write(System.lineSeparator().getBytes());
            outputStream.write(body);
        } catch (IOException e) {
            // TODO: log error message
            throw new RuntimeException(e);
        }

    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
}
