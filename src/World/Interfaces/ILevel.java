package World.Interfaces;

import World.Tile;

public interface ILevel {
    public Tile[][] getLevelTiles();
    int getLevelHeight();
    int getLevelWidth();
}
