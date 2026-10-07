package World;

import World.Enums.TileTypeEnum;

public class Tile {
    private TileTypeEnum _tile;

    public char GetTileChar() {
        switch (this._tile) {
            case Wall:
                return '█';
            case Stairs:
                return '≡';
            case Door:
                return '⌸';
            case Chest:
                return '⌼';
            case Floor:
            default:
                return ' ';
        }
    }

    public void SetTileType(TileTypeEnum tile) {
        this._tile = tile;
    }

    public TileTypeEnum GetTileType() {
        return this._tile;
    }

    public Tile(TileTypeEnum tile) {
        this.SetTileType(tile);
    }

    public Tile(char tileChar) {
        SetTileFromChar(tileChar);
    }

    private void SetTileFromChar(char c){
        switch (c) {
            case '█':
                this.SetTileType(TileTypeEnum.Wall);
                break;
            case '≡':
                this.SetTileType(TileTypeEnum.Stairs);
                break;
            case '⌸':
                this.SetTileType(TileTypeEnum.Door);
                break;
            case '⌼':
                this.SetTileType(TileTypeEnum.Chest);
                break;
            case ' ':
                this.SetTileType(TileTypeEnum.Floor);
                break;
        }
    }
}
