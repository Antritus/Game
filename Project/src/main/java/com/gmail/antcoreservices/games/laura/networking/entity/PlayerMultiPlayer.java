package com.gmail.antcoreservices.games.laura.networking.entity;

import com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.Player;
import com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.character.Character;
import com.gmail.antcoreservices.games.laura.main.GamePanel;
import com.gmail.antcoreservices.games.laura.main.KeyHandler;

import java.net.InetAddress;

public class PlayerMultiPlayer extends Player {
    private InetAddress ipAddress;
    private int port;

    public PlayerMultiPlayer(GamePanel gp, Character characterClass, String username, InetAddress ipAddress, int port) {
        super(gp, null, characterClass);
        this.port = port;
        this.ipAddress = ipAddress;
    }

    public PlayerMultiPlayer(GamePanel gp, KeyHandler keyH, Character characterClass, String username, InetAddress ipAddress, int port) {
        super(gp, keyH, characterClass);
        this.port = port;
        this.ipAddress = ipAddress;
    }

    @Override
    public void update() {
        super.update();
    }
}
