package com.gmail.antcoreservices.games.laura.map.tile;

import com.gmail.antcoreservices.games.laura.entity.Entity;

public class TileAttacker {
    public Entity lastAttackerEnt;
    public Tile lastAttackerTile;
    public TileAttackerType tileAttackerType;
    public TileAttacker(Entity entity, Tile tile, TileAttackerType tileAttackerType){
        this.lastAttackerEnt = entity;
        this.lastAttackerTile = tile;
        this.tileAttackerType = tileAttackerType;
    }
    public TileAttacker() {
        this.lastAttackerEnt   = null;
        this.lastAttackerTile  = null;
        this.tileAttackerType  = null;
    }


    public Object getLastAttacker() {
        if (this.tileAttackerType == TileAttackerType.ENTITY) {
            return lastAttackerEnt;
        } else if (this.tileAttackerType == TileAttackerType.TILE) {
            return lastAttackerTile;
        }
        return null;
    }

    public TileAttackerType getTileAttackerType() {
        return this.tileAttackerType;
    }
}
