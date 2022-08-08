package main;

public class Location {
    private double x;
    private double y;
    private World world;
    private Direction direction;
    private DefaultSettings ds = Main.getDefaultSettings();

    public static int getCol(GamePanel gp, double x) {
        return (int) (x/gp.getDefaultSettings().getTileSize());
    }

    public static int getRow(GamePanel gp, double y) {
        return (int) (y/gp.getDefaultSettings().getTileSize());
    }
    public Location() {
    }

    public Location(World world, double x, double y, double angle) {
        this.x = x;
        this.y = y;
        this.world = world;
        this.direction = Direction.getDirection(angle);
    }

    public Location(World world, double x, double y, Direction direction) {
        this.x = x;
        this.y = y;
        this.world = world;
        this.direction = direction;
    }

    public Location(World world, double x, double y) {
        this.x = x;
        this.y = y;
        this.world = world;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setDirection(double angle) {
        this.direction = Direction.getDirection(angle);
    }


    public int getCol(double x) {
        return (int) (x/ds.getTileSize());
    }

    public int getRow(double y) {
        return (int) (y/ds.getTileSize());
    }
}
