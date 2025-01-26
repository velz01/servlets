package com.velz.other;

import java.io.*;
import java.net.*;
import java.util.Scanner;


public class SocketServerRunner {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(6666);
        Socket socket = serverSocket.accept();
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in);
             ) {
            String request = dataInputStream.readUTF();
            while(!"stop".equals(request)) {

                String response = scanner.nextLine();
                dataOutputStream.writeUTF(response);
                request = dataInputStream.readUTF();
            }

        }
    }
}
