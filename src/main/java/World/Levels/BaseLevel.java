package World.Levels;

import Models.Actors.Monsters.BaseMonster;
import Models.Actors.Player.Character;
import World.Interfaces.ILevel;
import World.Tile;

import java.util.ArrayList;

public abstract class BaseLevel implements ILevel {

    protected String[] _levelLayout;

    protected Tile[][] _levelGrid;


    protected int _exitX = 0;
    protected int _exitY = 0;

    @Override
    public Tile[][] GetLevelTiles() {
        return this._levelGrid;
    }

    @Override
    public int GetLevelHeight() {
        return this._levelLayout.length;
    }

    @Override
    public int GetLevelWidth() {
        return this._levelLayout[0].length();
    }

    protected abstract void SetLevelExitLocation();

    abstract String[] SetLevelLayout();

    @Override
    public abstract void SetPlayerStartPosition(Character player);

    public boolean IsOnExitLocation(Character player) {
        if (_exitX == player.GetCurrentX() && _exitY == player.GetCurrentY())
            return true;

        return false;
    }

    @Override
    public abstract ArrayList<BaseMonster> GetMonsterList();

    protected void InitMap() {
        for (int y = 0; y < GetLevelHeight(); y++) {
            String row = this._levelLayout[y];
            for (int x = 0; x < GetLevelWidth(); x++) {
                char c = row.charAt(x);
                _levelGrid[y][x] = new Tile(c);
            }
        }
    }
}
