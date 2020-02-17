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
public class UDPclientSender extends Thread {
    Thread th;
    String ipAddr;
    @Override
    public void run() {
        //System.out.println("Starting sender\n");
        System.out.print("Input your user name >>");

        Scanner scn = new Scanner(System.in);
        String username = scn.nextLine();

        //int port = 10000;
        int BUFLEN = 1000; //buffer length for udp cant be more than 1500 bytes

        try (
            DatagramSocket clientSocket = new DatagramSocket();
        ) {
            InetAddress hostname = InetAddress.getByName(ipAddr);
            System.out.print(">>");

            do {
                Scanner scanner = new Scanner(System.in);
                String inputString = username + " : " + scanner.nextLine();
                byte[] buf = new byte[BUFLEN];
                buf = inputString.getBytes();
                DatagramPacket out = new DatagramPacket(buf, buf.length, hostname, 10000);
                clientSocket.send(out);

            } while (true);
        } catch (UnknownHostException e) {
            System.err.format("Error: %s", e.getMessage());
        } catch (IOException e) {
            System.err.format("Error: %s", e.getMessage());
        }

    }
    public void start(String ip) {
        ipAddr = ip;
          System.out.println("Thread started");
          if (th == null) {
           th = new Thread(this);
           th.start();
          }

         }
}