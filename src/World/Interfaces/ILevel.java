package World.Interfaces;

import Models.Actors.Monsters.BaseMonster;
import World.Tile;

import java.util.ArrayList;

public interface ILevel {
    public Tile[][] getLevelTiles();
    int getLevelHeight();
    int getLevelWidth();
    ArrayList<BaseMonster> GetLevelMonsters();
}
