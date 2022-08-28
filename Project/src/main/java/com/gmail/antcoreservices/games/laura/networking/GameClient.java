package com.gmail.antcoreservices.games.laura.networking;

import com.gmail.antcoreservices.games.laura.main.GamePanel;

import java.io.IOException;
import java.net.*;

public class GameClient extends Thread{
    private InetAddress ipAddress;
    private DatagramSocket socket;
    private GamePanel gp;
    public GameClient(GamePanel gp, String ipAddress) {
        this.gp = gp;
        try {
            this.socket = new DatagramSocket();
            this.ipAddress = InetAddress.getByName(ipAddress);
        } catch (SocketException | UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
    public void run() {
        while (true) {
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("SERVER: " + new String(packet.getData()));
        }
    }

    public void sendData(byte[] data) {
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, ipAddress, 1099);
        try {
            socket.send(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
