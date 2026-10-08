package World;

import Models.Actors.Monsters.BaseMonster;
import Services.LoggingService.ConsoleLogger;
import Services.LoggingService.Enums.ErrorLevelEnum;
import World.Enums.TileTypeEnum;
import World.Interfaces.ILevel;

import java.util.ArrayList;

public class GameBoard {

    //region Private Fields
    private ConsoleLogger _logger;
    private Tile[][] _grid;
    private ArrayList<BaseMonster> _monsters;

    public void SetMonsters(ArrayList<BaseMonster> monsters) {
        this._monsters = monsters;
    }

    public ArrayList<BaseMonster> GetMonsters() {
        return this._monsters;
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
        this.SetTiles(level.GetLevelTiles());
        this.SetMonsters(level.GetLevelMonsters());
    }

    public boolean IsWalkable(int x, int y) {
        try {
            if (x < 0 || x >= this.GetWidth() || y < 0 || y >= this.GetHeight()) {
                throw new IndexOutOfBoundsException("Coordinates out of bounds");
            }
        }catch (IndexOutOfBoundsException e) {
            _logger.LogError(ErrorLevelEnum.ERROR, e.getMessage());
            throw e;
        }

        if (x < 1 || x >= this.GetWidth()-1 || y < 1 || y >= this.GetHeight()-1)
            return false; // Hit an outer wall

        return this.GetTile(x, y).GetTileType() != TileTypeEnum.Wall;
    }

    public int GetHeight() {
        return this._grid.length;
    }

    public int GetWidth() {
        return this._grid[0].length;
    }
}
