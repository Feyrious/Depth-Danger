package World;

import World.Enums.TileTypeEnum;
import World.Interfaces.ILevel;

public class Board {

    //region Private Fields
    private Tile[][] _grid;
    private int _width;
    private int _height;

    public void setHeight(int height) {
        this._height = height;
    }

    public int getHeight() {
        return this._height;
    }

    public void setWidth(int width) {
        this._width = width;
    }

    public int getWidth() {
        return this._width;
    }

    private void setTiles(Tile[][] tiles) {
        this._grid = tiles;
    }

    private Tile[][] getTiles() {
        return this._grid;
    }
    //endregion

    public Board(ILevel level) {
        this.setHeight(level.getLevelHeight());
        this.setWidth(level.getLevelWidth());
        this.setTiles(level.getLevelTiles());
    }

    private char RenderTileType(TileTypeEnum tile) {
        switch (tile) {
            case Wall:
                return '█';
            case Stairs:
                return '≡';
            case Door:
                return '⌸';
            case Floor:
            default:
                return ' ';
        }
    }
}
