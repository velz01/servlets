package com.velz.other.server;

public class HttpServerRunner {
    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer(100,9000);
        httpServer.run();
    }
}
