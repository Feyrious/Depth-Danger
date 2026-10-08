package World.Interfaces;

import Models.Actors.Monsters.BaseMonster;
import Models.Actors.Player.Character;
import World.Tile;

import java.util.ArrayList;

public interface ILevel {
    String[] _levelLayout = new String[0];
    Tile[][] GetLevelTiles();
    int getLevelHeight();
    int getLevelWidth();
    void SetPlayerStartPosition(Character player);
    ArrayList<BaseMonster> GetLevelMonsters();
}
