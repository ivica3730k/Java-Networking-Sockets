/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpserver;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;


/**
 *
 * @author n0781349
 */
class UDPserver {

    public static void run() {
        System.out.println("Starting to run server");
        int port = 10000;
        int BUFLEN = 1000; //buffer length for udp cant be more than 1500 bytes


        try (
            DatagramSocket serverSocket = new DatagramSocket(port);
        ) {

            do {
                byte[] buf = new byte[BUFLEN];
                DatagramPacket receivedPacket = new DatagramPacket(buf, BUFLEN);
                serverSocket.receive(receivedPacket);
                String s = new String(buf, StandardCharsets.UTF_8);
                System.out.println(s);
                
            } while (true);
        } catch (IOException e) {
            System.err.format("Error: %s", e.getMessage());
        }
    }


}