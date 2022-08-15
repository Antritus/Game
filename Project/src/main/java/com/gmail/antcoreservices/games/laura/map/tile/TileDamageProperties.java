package com.gmail.antcoreservices.games.laura.map.tile;

import com.gmail.antcoreservices.games.laura.entity.Entity;

public class TileDamageProperties {
    private TileDamageCause tileDamageCause = null; // setting all values to null to have no errors
    private Entity lastEntityAttacker = null;
    private Tile lastTileAttacker = null;

    public Entity getLastEntityAttacker(){
        return lastEntityAttacker;
    }
    public Tile getLastTileAttacker() {
        return lastTileAttacker;
    }

}
