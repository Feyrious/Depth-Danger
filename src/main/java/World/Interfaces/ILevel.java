package World.Interfaces;

import Models.Actors.Monsters.BaseMonster;
import Models.Actors.Player.Character;
import Models.Items.Treasure;
import World.Tile;

import java.util.ArrayList;

public interface ILevel {
    int GetLevelNumber();
    String GetLevelCode();
    String[] _levelLayout = new String[0];
    Tile[][] GetLevelTiles();
    int GetLevelHeight();
    int GetLevelWidth();
    void SetPlayerStartPosition(Character player);
    boolean IsOnExitLocation(Character player);
    ArrayList<BaseMonster> GetMonsterList();
    ArrayList<Treasure> GetTreasureList();
}
