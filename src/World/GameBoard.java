package World;

import Models.Actors.Monsters.BaseMonster;
import Services.LoggingService.ConsoleLogger;
import Services.LoggingService.Enums.ErrorLevelEnum;
import World.Enums.TileTypeEnum;
import World.Interfaces.ILevel;
import Models.Actors.Player.Character;

import java.util.ArrayList;

public class GameBoard {

    //region Private Fields
    private ConsoleLogger _logger;
    private Tile[][] _grid;
    private int _width;
    private int _height;
    private ArrayList<BaseMonster> _monsters;

    public void SetMonsters(ArrayList<BaseMonster> monsters) {
        this._monsters = monsters;
    }

    public ArrayList<BaseMonster> GetMonsters() {
        return this._monsters;
    }

    public void SetHeight(int height) {
        this._height = height;
    }

    public int GetHeight() {
        return this._height;
    }

    public void SetWidth(int width) {
        this._width = width;
    }

    public int GetWidth() {
        return this._width;
    }

    private void SetTiles(Tile[][] tiles) {
        this._grid = tiles;
    }

    public Tile GetTile(int x, int y) {
        return this._grid[y][x];
    }
    //endregion

    public GameBoard(ILevel level) {
        _logger = new ConsoleLogger();
        this.SetHeight(level.getLevelHeight());
        this.SetWidth(level.getLevelWidth());
        this.SetTiles(level.getLevelTiles());
    }

    public boolean IsWalkable(int x, int y) {
        try {
            if (x < 0 || x >= this._width || y < 0 || y >= this._height) {
                throw new IndexOutOfBoundsException("Coordinates out of bounds");
            }
        }catch (IndexOutOfBoundsException e) {
            _logger.LoggError(ErrorLevelEnum.ERROR, e.getMessage());
            throw e;
        }

        if (x < 1 || x >= this._width-1 || y < 1 || y >= this._height-1)
            return false; // Hit an outer wall

        return this.GetTile(x, y).GetTileType() != TileTypeEnum.Wall;
    }
}
