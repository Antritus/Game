package com.gmail.antcoreservices.games.laura.map.world;

import com.gmail.antcoreservices.games.laura.entity.Entity;
import com.gmail.antcoreservices.games.laura.entity.livingentity.CommonAI;
import com.gmail.antcoreservices.games.laura.entity.livingentity.LivingEntity;
import com.gmail.antcoreservices.games.laura.entity.livingentity.hostile.HostileEntity;
import com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.Player;
import com.gmail.antcoreservices.games.laura.entity.object.Object;
import com.gmail.antcoreservices.games.laura.map.tile.Tile;

import java.util.ArrayList;
import java.util.List;

public class WorldProperties {

    private int maxCol;
    private int maxRow;
    private int maxLayers;
    private int objectCount;
    private int loadedCol;
    private int loadedMaxCol;
    private int loadedRow;
    private int loadedMaxRow;
    private int loadedX;
    private int loadedMaxX;
    private int loadedY;
    private int loadedMaxY;

    private boolean isLoaded;




    private void loadWorld(int world) {
        //todo
    }

    private Tile[][][] tiles = new Tile[10][10][10]; // layer, col, row

    private final List<Player> players = new ArrayList<>();
    private final List<LivingEntity> livingEntities = new ArrayList<>();
    private final List<HostileEntity> hostileEntities = new ArrayList<>();
    private final List<Object> objects = new ArrayList<>();
    private final List<Entity> entities = new ArrayList<>();

    private void loadWorld(String world) {
        //todo
    }

    public WorldProperties(int maxCol, int maxRow, int maxLayers, Entity[] entities, boolean isLoaded) {
        this.maxCol = maxCol;
        this.maxRow = maxRow;
        this.maxLayers = maxLayers;
        if (entities != null){
            for (Entity entity : entities) {
                if (entity instanceof CommonAI) {
                }
                if (entity instanceof HostileEntity){
                    this.hostileEntities.add((HostileEntity) entity);
                }
                if (entity instanceof LivingEntity){
                    this.livingEntities.add((LivingEntity) entity);
                }
                if (entity instanceof Player){
                    this.players.add((Player) entity);
                }
                if (entity instanceof Object){
                    this.objects.add((Object) entity);
                }
                this.entities.add(entity);
            }
        }
        this.isLoaded = isLoaded;
    }

    public List<Player> getPlayers() {
        return players;
    }
    public List<HostileEntity> getHostileEntities() {
        return hostileEntities;
    }
    public List<LivingEntity> getLivingEntities() {
        return livingEntities;
    }
    public List<Object> getObjects() {
        return objects;
    }
    public List<Entity> getEntities() {
        return entities;
    }

    public int getMaxCol() {
        return maxCol;
    }

    public void setMaxCol(int maxCol) {
        this.maxCol = maxCol;
    }

    public int getMaxRow() {
        return maxRow;
    }

    public void setMaxRow(int maxRow) {
        this.maxRow = maxRow;
    }

    public int getMaxLayers() {
        return maxLayers;
    }

    public void setMaxLayers(int maxLayers) {
        this.maxLayers = maxLayers;
    }




    public boolean isLoaded() {
        return isLoaded;
    }

    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
    }

    public Tile[][][] getTiles() {
        return tiles;
    }
    public void setTiles(Tile[][][] tiles) {
        this.tiles = tiles;
    }
    public void setTile(int layer, int col, int row, Tile tile) {
        this.tiles[layer][col][row] = tile;
    }
    public Tile getTile(int layer, int col, int row) {
        return this.tiles[layer][col][row];
    }

    public int getLoadedCol() {
        return loadedCol;
    }

    public void setLoadedCol(int loadedCol) {
        this.loadedCol = loadedCol;
    }

    public int getLoadedMaxCol() {
        return loadedMaxCol;
    }

    public void setLoadedMaxCol(int loadedMaxCol) {
        this.loadedMaxCol = loadedMaxCol;
    }

    public int getLoadedRow() {
        return loadedRow;
    }

    public void setLoadedRow(int loadedRow) {
        this.loadedRow = loadedRow;
    }

    public int getLoadedMaxRow() {
        return loadedMaxRow;
    }

    public void setLoadedMaxRow(int loadedMaxRow) {
        this.loadedMaxRow = loadedMaxRow;
    }

    public int getLoadedX() {
        return loadedX;
    }

    public void setLoadedX(int loadedX) {
        this.loadedX = loadedX;
    }

    public int getLoadedMaxX() {
        return loadedMaxX;
    }

    public void setLoadedMaxX(int loadedMaxX) {
        this.loadedMaxX = loadedMaxX;
    }

    public int getLoadedY() {
        return loadedY;
    }

    public void setLoadedY(int loadedY) {
        this.loadedY = loadedY;
    }

    public int getLoadedMaxY() {
        return loadedMaxY;
    }

    public void setLoadedMaxY(int loadedMaxY) {
        this.loadedMaxY = loadedMaxY;
    }
}
