package com.velz.other;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketRunner {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 6666);
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream inputStream = new DataInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String request = scanner.nextLine();
                outputStream.writeUTF(request);
                System.out.println(inputStream.readUTF());
            }

        }
    }
}
