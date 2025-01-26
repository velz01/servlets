package com.velz.other;

import java.io.IOException;
import java.net.*;

public class DatagramRunner {
    public static void main(String[] args) throws IOException {
        InetAddress localhost = InetAddress.getByName("localhost");
        try (DatagramSocket datagramSocket = new DatagramSocket()) {

            byte[] bytes = "Hello UDP".getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length,localhost,6666);
            datagramSocket.send(packet);
        }
    }
}
