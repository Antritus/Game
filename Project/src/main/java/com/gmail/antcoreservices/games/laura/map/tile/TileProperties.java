package com.gmail.antcoreservices.games.laura.map.tile;

public class TileProperties {
    private final double maxHealth;
    private final int toughness;

    private double health;
    private boolean isDestructible;
    private boolean isSolid;
    private boolean isLiquid;
    private boolean isHoeable;
    private boolean isPickable;
    public TileProperties(double maxHealth, double health, int toughness, boolean isDestructible, boolean isSolid, boolean isLiquid, boolean isHoeable, boolean isPickable) {
        this.health = health;
        this.isDestructible = isDestructible;
        this.isSolid = isSolid;
        this.isLiquid = isLiquid;
        this.isHoeable = isHoeable;
        this.isPickable = isPickable;
        this.toughness = toughness;
        this.maxHealth = maxHealth;
    }

    public boolean isPickable() {
        return isPickable;
    }

    public boolean isHoeable() {
        return isHoeable;
    }

    public boolean isLiquid() {
        return isLiquid;
    }

    public boolean isSolid() {
        return isSolid;
    }

    public boolean isDestructible() {
        return isDestructible;
    }

    public double getHealth() {
        return health;
    }

    public int getToughness() {
        return toughness;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setHealth(double health) {
        this.health = health;
    }
    public void setSolid(boolean v) {
        this.isSolid = v;
    }
    public void setLiquid(boolean v) {
        this.isSolid = v;
    }
    public void setHoeable(boolean v) {
        this.isHoeable = v;
    }
    public void setDestructible(boolean v) {
        this.isDestructible = v;
    }
    public void setPickable(boolean v) {
        this.isPickable = v;
    }
}
