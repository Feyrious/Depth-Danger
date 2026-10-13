package World;

import Services.UIServices.ConsoleFormater;
import World.Enums.TileTypeEnum;

public class Tile {
    private TileTypeEnum _tile;

    public String GetTileChar() {
        switch (this._tile) {
            case Wall:
                return ConsoleFormater.COLOR_BROWN + "█" + ConsoleFormater.COLOR_RESET;
            case Stairs:
                return ConsoleFormater.COLOR_GREY + "≡" + ConsoleFormater.COLOR_RESET;
            case Door:
                return ConsoleFormater.COLOR_DARK_BROWN + "⌸" + ConsoleFormater.COLOR_RESET;
            case Floor:
                return " ";
            case Chest:
                return ConsoleFormater.COLOR_BROWN + "⌼" + ConsoleFormater.COLOR_RESET;
            case Character:
                return ConsoleFormater.COLOR_BRIGHT_YELLOW + "☺" + ConsoleFormater.COLOR_RESET;
            case Goblin:
                return ConsoleFormater.COLOR_DARK_GREEN + "ô" + ConsoleFormater.COLOR_RESET;
            default:
                return " ";
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
            case '☺':
                this.SetTileType(TileTypeEnum.Character);
                break;
            case 'ô':
                this.SetTileType(TileTypeEnum.Goblin);
                break;
            default:
                this.SetTileType(TileTypeEnum.Floor);
                break;
        }
    }
}
