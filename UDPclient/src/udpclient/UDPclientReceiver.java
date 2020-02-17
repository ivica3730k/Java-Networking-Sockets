/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpclient;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author ivica
 */
public class UDPclientReceiver extends Thread {
    Thread th;
    @Override
    public void run(){
        //System.out.println("Runing receiver");
        int BUFLEN = 1000; //buffer length for udp cant be more than 1500 bytes

        try (
            DatagramSocket serverSocket = new DatagramSocket(10001);
        ) {
            do {
                byte[] buf = new byte[BUFLEN];
                DatagramPacket receivedPacket = new DatagramPacket(buf, BUFLEN);
                serverSocket.receive(receivedPacket);
                String s = new String(buf, StandardCharsets.UTF_8);
                System.out.println(s);
                System.out.print(">>");


            } while (true);
        } catch (IOException e) {
            System.err.format("Error: %s", e.getMessage());
        }
    }
    @Override
    public void start() {
      System.out.println("Thread started");
      if (th == null) {
       th = new Thread(this);
       th.start();
      }

     }
    
    
}
