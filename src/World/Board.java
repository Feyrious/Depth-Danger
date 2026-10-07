package World;

import World.Enums.TileTypeEnum;
import World.Interfaces.ILevel;

public class Board {

    //region Private Fields
    private Tile[][] _grid;
    private int _width;
    private int _height;

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

    private Tile[][] GetTiles() {
        return this._grid;
    }
    //endregion

    public Board(ILevel level) {
        this.SetHeight(level.getLevelHeight());
        this.SetWidth(level.getLevelWidth());
        this.SetTiles(level.getLevelTiles());
    }

    public boolean IsWalkable(int x, int y) {
        if (x < 0 || x >= this._width || y < 0 || y >= this._height) {
            return false; // Out of bounds check
        }

        return this._grid[y][x].GetTileType() != TileTypeEnum.Wall;
    }
}
