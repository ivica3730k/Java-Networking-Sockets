/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpserver;
import java.util.*; 
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
        //int port = 10000;
        int BUFLEN = 1000; //buffer length for udp cant be more than 1500 bytes


        try (
            DatagramSocket serverSocket = new DatagramSocket(10000);
        ) {

            ArrayList v = new ArrayList(); 
            do {
                byte[] buf = new byte[BUFLEN];
                DatagramPacket receivedPacket = new DatagramPacket(buf, BUFLEN);
                serverSocket.receive(receivedPacket);
                if (!v.contains(receivedPacket.getAddress())) {
                    System.out.println("New client connected!");
                    v.add(receivedPacket.getAddress()); 
                }
                String s = new String(buf, StandardCharsets.UTF_8);
                //System.out.println(s);
                Iterator value = v.iterator(); 
                for(Object a : v){
                    DatagramSocket clientSocket = new DatagramSocket();
                    InetAddress hostname = (InetAddress) a;
                    DatagramPacket out = new DatagramPacket(buf, buf.length,hostname, 10001);
                    clientSocket.send(out);
                    System.out.println(hostname);

                }

            } while (true);
        } catch (IOException e) {
            System.err.format("Error: %s", e.getMessage());
        }
    }


}