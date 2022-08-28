package com.gmail.antcoreservices.games.laura.networking;

import com.gmail.antcoreservices.games.laura.main.GamePanel;

import java.io.IOException;
import java.net.*;

public class GameServer extends Thread{
    private DatagramSocket socket;
    private GamePanel gp;
    public GameServer(GamePanel gp) {
        this.gp = gp;
        try {
            this.socket = new DatagramSocket();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }
    public void run() {
        while (true) {
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, 0, data.length, socket.getInetAddress(), socket.getPort());
            try {
                socket.receive(packet);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String message = new String(packet.getData());
            System.out.println("Client: [" + packet.getAddress().getHostAddress() + ":" + packet.getPort() + "]> " + message);
            if (message.equalsIgnoreCase("ping")){
                System.out.println("Returning pong!");
                sendData("pong".getBytes(), packet.getAddress(), packet.getPort());
            }
        }
    }

    public void sendData(byte[] data, InetAddress ipAddress, int port) {
        DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port);
        try {
            socket.send(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
