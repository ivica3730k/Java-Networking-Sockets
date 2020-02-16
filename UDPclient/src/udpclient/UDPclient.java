/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpclient;

import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author n0781349
 */
public class UDPclient {


    public static void run() {
        System.out.println("Starting to run client");
        int port = 10000;
        int BUFLEN = 1000; //buffer length for udp cant be more than 1500 bytes
        
        try (
            DatagramSocket clientSocket = new DatagramSocket();
        ) {
            InetAddress hostname = InetAddress.getByName("localhost");
            do {
                System.out.print(">> ");
                Scanner scanner = new Scanner(System.in);
                String inputString = scanner.nextLine();
                //System.out.println(inputString);
                byte[] buf = new byte[BUFLEN];
                buf = inputString.getBytes();
                DatagramPacket out = new DatagramPacket(buf, buf.length,hostname, port);
                clientSocket.send(out);
                
            } while (true);
        } catch (UnknownHostException e) {
            System.err.format("Error: %s", e.getMessage());
        } catch (IOException e) {
            System.err.format("Error: %s", e.getMessage());
        }

    }

}