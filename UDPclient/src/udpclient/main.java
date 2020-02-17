/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpclient;

/**
 *
 * @author n0781349
 */
public class main {
    public static void main(String[] args) {
        String ip = args[0];
        UDPclientSender sender = new UDPclientSender();
        UDPclientReceiver receiver = new UDPclientReceiver();
        sender.start(ip);
        receiver.start();
    }
}
