package com.gmail.antcoreservices.games.laura.networking.packet.packets;

import com.gmail.antcoreservices.games.laura.networking.GameClient;
import com.gmail.antcoreservices.games.laura.networking.GameServer;
import com.gmail.antcoreservices.games.laura.networking.packet.Packet;

public class Packet0001Login extends Packet {
    private String username;
    public Packet0001Login(byte[] data) {
        super(00);
        this.username = readData(data);
    }

    @Override
    public byte[] getData() {
        return ("00" + this.username).getBytes();
    }

    @Override
    public void writeData(GameClient gameClient) {
    }

    @Override
    public void writeData(GameServer gameClient) {
    }
}
