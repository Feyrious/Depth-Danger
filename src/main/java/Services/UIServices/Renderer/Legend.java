package Services.UIServices.Renderer;

import World.Enums.TileTypeEnum;
import World.Tile;

public class Legend {
    public static void RenderLegend() {
        System.out.println("╭───────────────────────────────────────╮");
        System.out.println("│ W: Up   A: Left   S: Down   D: Right  │");
        System.out.println("│ " + new Tile(TileTypeEnum.Wall).GetTileChar() + ": Wall  " + new Tile(TileTypeEnum.Door).GetTileChar() + ": Door  " + new Tile(TileTypeEnum.Chest).GetTileChar() + ": Chest  " + new Tile(TileTypeEnum.Stairs).GetTileChar() + ": Stairs │");
        System.out.println("╰───────────────────────────────────────╯");
    }
}
