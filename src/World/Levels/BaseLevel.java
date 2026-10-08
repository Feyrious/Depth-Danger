package World.Levels;

import Models.Actors.Monsters.BaseMonster;
import Models.Actors.Player.Character;
import World.Interfaces.ILevel;
import World.Tile;

import java.util.ArrayList;

public abstract class BaseLevel implements ILevel {

    protected String[] _levelLayout;

    protected Tile[][] _levelGrid;

    @Override
    public Tile[][] GetLevelTiles() {
        return this._levelGrid;
    }

    @Override
    public int getLevelHeight() {
        return this._levelLayout.length;
    }

    @Override
    public int getLevelWidth() {
        return this._levelLayout[0].length();
    }

    abstract String[] SetLevelLayout();

    @Override
    public abstract void SetPlayerStartPosition(Character player);

    @Override
    public abstract ArrayList<BaseMonster> GetLevelMonsters();

    protected void InitMap() {
        for (int y = 0; y < getLevelHeight(); y++) {
            String row = this._levelLayout[y];
            for (int x = 0; x < getLevelWidth(); x++) {
                char c = row.charAt(x);
                _levelGrid[y][x] = new Tile(c);
            }
        }
    }
}
